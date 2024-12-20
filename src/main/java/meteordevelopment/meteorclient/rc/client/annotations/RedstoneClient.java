/*
 * This file is part of the Meteor Client distribution (https://github.com/MeteorDevelopment/meteor-client).
 * Copyright (c) Meteor Development.
 */

package meteordevelopment.meteorclient.rc.client.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks a class as a Redstone client class.
 * <p>
 * This is used to identify classes that are part of the Redstone client.
 * It is only used in packages that are not part of the <code>meteordevelopment.meteorclient.rc</code> Package.
 * The only reason this is used is to make it easier to identify classes that are part of the Redstone client.
 * </p>
 *
 * @author Splatcrafter
 * @since 1.0.0rc
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface RedstoneClient {
}
