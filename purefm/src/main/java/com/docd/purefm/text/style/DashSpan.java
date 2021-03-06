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
package com.docd.purefm.text.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;

public final class DashSpan implements LeadingMarginSpan {
    
    private static final String SPAN = "- ";
    
    private int mMargin;

    public DashSpan() {
        this.mMargin = -1;
    }
    
    @Override
    public void drawLeadingMargin(final Canvas c,
                                  final Paint p,
                                  final int x,
                                  final int dir,
                                  final int top,
                                  final int baseline,
                                  final int bottom,
                                  final CharSequence text,
                                  final int start,
                                  final int end,
                                  final boolean first,
                                  final Layout layout) {
        if (first) {
            if (mMargin == -1) {
                mMargin = (int) p.measureText(SPAN);
            }
            c.drawText(SPAN, x + dir, baseline, p);
        }
    }

    @Override
    public int getLeadingMargin(final boolean first) {
        return mMargin;
    }
}