/*
 * This file is part of the Meteor Client distribution (https://github.com/MeteorDevelopment/meteor-client).
 * Copyright (c) Meteor Development.
 */

package meteordevelopment.meteorclient.rc.client.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public class LoggerUtils {

    private static final String PREFIX = "Redstone Client";
    public static final Logger LOGGER = LogManager.getLogger(PREFIX);

    public static Logger getLogger(@NotNull final String string) {
        return LogManager.getLogger(PREFIX + " | " + string);
    }
}
