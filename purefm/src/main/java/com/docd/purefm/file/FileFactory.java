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
package com.docd.purefm.file;

import android.os.Looper;

import com.docd.purefm.Environment;
import com.docd.purefm.commandline.ShellHolder;
import com.docd.purefm.settings.Settings;

import android.support.annotation.NonNull;

import java.io.File;

public final class FileFactory {
    private FileFactory() {}


    @NonNull
    public static GenericFile newFile(@NonNull final Settings settings,
                                      @NonNull final String path) {
        //if (Looper.myLooper() == Looper.getMainLooper()) {
            //throw new RuntimeException("Wrong thread");
        //} TODO check this
        return settings.useCommandLine() && Environment.hasBusybox() &&
                ShellHolder.getInstance().hasShell() ?
                        CommandLineFile.fromFile(settings, new File(path)) :
                                new JavaFile(path);
    }

    @NonNull
    public static GenericFile newFile(@NonNull final Settings settings,
                                      @NonNull final File path) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new RuntimeException("Wrong thread");
        }
        return settings.useCommandLine() && Environment.hasBusybox() &&
                ShellHolder.getInstance().hasShell() ?
                        CommandLineFile.fromFile(settings, path) :
                                new JavaFile(path);
    }

    @NonNull
    public static GenericFile newFile(@NonNull final Settings settings,
                                      @NonNull final File parent,
                                      @NonNull final String name) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new RuntimeException("Wrong thread");
        }
        return settings.useCommandLine() && Environment.hasBusybox() &&
                ShellHolder.getInstance().hasShell() ?
                        CommandLineFile.fromFile(settings, new File(parent, name)) :
                                new JavaFile(parent, name);
    }
}
