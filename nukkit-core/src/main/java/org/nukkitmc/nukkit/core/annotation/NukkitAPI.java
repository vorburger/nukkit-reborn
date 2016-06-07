package org.nukkitmc.nukkit.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 'NukkitAPI' annotation, marks all application interfaces, that is allowed to use in plugins or modules.
 * Methods, packages or classes without this mark are internal classes are not allowed to call or use.
 * If any classes or methods without this symbol is called, it might not be compatible in further updates,
 * and might cause bugs and crashes.
 *
 * @author Mulan Lin
 */
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.METHOD, ElementType.PACKAGE, ElementType.TYPE})
public @interface NukkitAPI {}
