package org.nukkitmc.nukkitstd.mcpe.v0_14_3.network.protocol;

import org.nukkitmc.nukkit.math.*;
import org.nukkitmc.nukkitstd.mcpe.general.MCPEItemIdentifier;
import org.nukkitmc.nukkitstd.minecraft.ItemIdentifier;
import org.nukkitmc.nukkitstd.minecraft.Skin;
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

    void putChunkVector(ChunkVector vector) {
        this.putInt(vector.getChunkX());
        this.putInt(vector.getChunkZ());
    }

    void putBlockVector(BlockVector vector) {
        this.putInt(vector.getBlockX());
        this.putInt(vector.getBlockY());
        this.putInt(vector.getBlockZ());
    }

    BlockVector getBlockVector(){
        int x = this.getInt();
        int y = this.getInt();
        int z = this.getInt();
        return new BlockVector() {
            @Override
            public int getBlockX() {return x;}

            @Override
            public int getBlockY() {return y;}

            @Override
            public int getBlockZ() {return z;}
        };
    }

    void putEntityVector(EntityVector vector) {
        this.putFloat(vector.getEntityX());
        this.putFloat(vector.getEntityY());
        this.putFloat(vector.getEntityZ());
    }

    EntityVector getEntityVector(){
        float x = this.getFloat();
        float y = this.getFloat();
        float z = this.getFloat();
        return new EntityVector() {
            @Override
            public float getEntityX() {return x;}

            @Override
            public float getEntityY() {return y;}

            @Override
            public float getEntityZ() {return z;}
        };
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

    HeadedEntityRotation getHeadedEntityRotation() {
        float yaw = this.getFloat();
        float headYaw = this.getFloat();
        float pitch = this.getFloat();
        return new HeadedEntityRotation() {
            @Override
            public float getPitch() {return pitch;}

            @Override
            public float getYaw() {return yaw;}

            @Override
            public float getHeadYaw() {return headYaw;}
        };
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
        this.putShort(id.asIntegerMeta()); //*todo: verify: this.putShort(!item.hasMeta() ? -1 : item.getDamage());

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
        return new IdCntSlot(id, data, cnt);    //OLD CODE: return Item.get(id, data, cnt, nbt);
    }

    void putSkin(Skin skin) {
        this.putString(skin.getSkinModel());
        this.putShort(skin.getSkinData().length);
        this.put(skin.getSkinData());
    }

    Skin getSkin() {
        String modelId = this.getString();
        byte[] skinData = this.get(this.getShort());
        return new Skin(){
            @Override
            public byte[] getSkinData() {return skinData;}

            @Override
            public String getSkinModel() {return modelId;}
        };
    }


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
