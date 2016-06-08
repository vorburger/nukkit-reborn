package org.nukkitmc.nukkitstd.mcpe.v0_14_3.network.protocol;

import org.nukkitmc.nukkit.math.EntityRotation;
import org.nukkitmc.nukkit.math.EntityVector;
import org.nukkitmc.nukkit.math.HeadedEntityRotation;
import org.nukkitmc.nukkit.math.Velocity;
import org.nukkitmc.nukkitstd.mcpe.general.MCPEItemIdentifier;
import org.nukkitmc.nukkitstd.minecraft.ItemIdentifier;
import org.nukkitmc.nukkitstd.minecraft.Slot;

/**
 * Created by Mulan Lin('Snake1999') at 2016/6/8.
 */
public abstract class DataPacket extends org.nukkitmc.nukkitstd.rak.DataPacket {

    @Override
    public DataPacket clone() {
        return (DataPacket) super.clone();
    }

    /** Package-local binary helpers **/

    void putEntityVector(EntityVector vector) {
        this.putFloat(vector.getEntityX());
        this.putFloat(vector.getEntityY());
        this.putFloat(vector.getEntityZ());
    }

    void putVelocity(Velocity velocity) {
        this.putFloat(velocity.getVelocityX());
        this.putFloat(velocity.getVelocityY());
        this.putFloat(velocity.getVelocityZ());
    }

    void putHeadedEntityRotation(HeadedEntityRotation rotation) {
        this.putFloat(rotation.getYaw());
        this.putFloat(rotation.getHeadYaw());
        this.putFloat(rotation.getPitch());
    }

    void putEntityRotation(EntityRotation rotation) {
        this.putFloat(rotation.getYaw());
        this.putFloat(rotation.getPitch());
    }

    void putSlot(Slot slot) {
        if (slot == null || slot.getItemIdentifier().asIntegerId() == 0) {
            this.putShort(0);
            return;
        }
        ItemIdentifier id = slot.getItemIdentifier();
        this.putShort(id.asIntegerId());
        this.putByte((byte) (slot.getItemCount() & 0xff));
        this.putShort(id.asIntegerMeta()); //this.putShort(!item.hasMeta() ? -1 : item.getDamage());

        // TODO: 2016/6/8 NBT
        //byte[] nbt = item.getCompoundTag();
        //this.putLShort(nbt.length);
        this.putLShort(0);
        //this.put(nbt);
    }

    Slot getSlot() {
        short id = this.getSignedShort();

        if (id <= 0) return new IdCntSlot(0, 0, 0);

        int cnt = this.getByte();
        int data = this.getShort();
        int nbtLen = this.getLShort();

        byte[] nbt = new byte[0];
        if (nbtLen > 0) nbt = this.get(nbtLen);
        // TODO: 2016/6/8 NBT
        //return Item.get(id, data, cnt, nbt);
        return new IdCntSlot(id, data, cnt);
    }

    // TODO: 2016/6/8 SKIN
    /*

    public void putSkin(Skin skin) {
        this.putString(skin.getModel());
        this.putShort(skin.getData().length);
        this.put(skin.getData());
    }

    public Skin getSkin() {
        String modelId = this.getString();
        byte[] skinData = this.get(this.getShort());
        return new Skin(skinData, modelId);
    }
     */

    private class IdCntSlot implements Slot {
        private ItemIdentifier id;
        private int count;
        IdCntSlot(int id, int meta, int count) {
            this.id = new MCPEItemIdentifier(id, meta);
            this.count = count;
        }

        @Override
        public ItemIdentifier getItemIdentifier() {return id;}

        @Override
        public int getItemCount() {return count;}
    }

}
