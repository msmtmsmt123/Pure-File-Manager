/*
 * Copyright 2014 Yaroslav Mytkalyk
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.docd.purefm.commandline;

import com.docd.purefm.file.GenericFile;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * du - estimate file space usage
 * -s  display only a total for each argument
 */
public final class CommandDu extends BusyboxCommand {

    public CommandDu(@NotNull final GenericFile file) {
        super("du -s " + file.getAbsolutePath());
    }

    public static long du_s(@NotNull final GenericFile file) {
        final List<String> result = CommandLine.executeForResult(ShellHolder.getShell(),
                new CommandDu(file));
        if (result == null || result.isEmpty()) {
            return 0L;
        }
        final String res = result.get(0);
        final int resLength = res.length();
        final StringBuilder lengthString = new StringBuilder(resLength);
        for (int i = 0; i < resLength; i++) {
            final char character = res.charAt(i);
            if (Character.isDigit(character)) {
                lengthString.append(character);
            } else {
                break;
            }
        }
        try {
            return Long.parseLong(lengthString.toString()) * FileUtils.ONE_KB;
        } catch (NumberFormatException e) {
            return 0L;
        }
    }
}
