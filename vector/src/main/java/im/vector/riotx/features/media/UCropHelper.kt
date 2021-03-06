/*
 * Copyright (c) 2020 New Vector Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package im.vector.riotx.features.media

import android.content.Context
import android.graphics.Color
import android.net.Uri
import androidx.core.content.ContextCompat
import com.yalantis.ucrop.UCrop
import com.yalantis.ucrop.UCropActivity
import im.vector.riotx.R
import im.vector.riotx.features.themes.ThemeUtils

fun createUCropWithDefaultSettings(context: Context, source: Uri, destination: Uri, toolbarTitle: String?): UCrop {
    return UCrop.of(source, destination)
            .withOptions(
                    UCrop.Options()
                            .apply {
                                setAllowedGestures(
                                        /* tabScale = */ UCropActivity.SCALE,
                                        /* tabRotate = */ UCropActivity.ALL,
                                        /* tabAspectRatio = */ UCropActivity.SCALE
                                )
                                setToolbarTitle(toolbarTitle)
                                // Disable freestyle crop, usability was not easy
                                // setFreeStyleCropEnabled(true)
                                // Color used for toolbar icon and text
                                setToolbarColor(ThemeUtils.getColor(context, R.attr.riotx_background))
                                setToolbarWidgetColor(ThemeUtils.getColor(context, R.attr.vctr_toolbar_primary_text_color))
                                // Background
                                setRootViewBackgroundColor(ThemeUtils.getColor(context, R.attr.riotx_background))
                                // Status bar color (pb in dark mode, icon of the status bar are dark)
                                setStatusBarColor(ThemeUtils.getColor(context, R.attr.riotx_header_panel_background))
                                // Known issue: there is still orange color used by the lib
                                // https://github.com/Yalantis/uCrop/issues/602
                                setActiveControlsWidgetColor(ContextCompat.getColor(context, R.color.riotx_accent))
                                // Hide the logo (does not work)
                                setLogoColor(Color.TRANSPARENT)
                            }
            )
}
