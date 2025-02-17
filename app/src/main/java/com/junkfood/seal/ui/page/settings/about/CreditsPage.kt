package com.junkfood.seal.ui.page.settings.about


import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.junkfood.seal.R
import com.junkfood.seal.ui.component.CreditItem
import com.junkfood.seal.ui.component.LargeTopAppBar

data class Credit(val title: String = "", val license: String? = null, val url: String = "")

const val GPL_V3 = "GNU General Public License v3.0"
const val APACHE_V2 = "Apache License, Version 2.0"
const val UNLICENSE = "The Unlicense"

const val youtubedlAndroidUrl = "https://github.com/yausername/youtubedl-android"
const val ytdlpUrl = "https://github.com/yt-dlp/yt-dlp"
const val readYou = "https://github.com/Ashinch/ReadYou"
const val musicYou = "https://github.com/Kyant0/MusicYou"
const val dvd = "https://github.com/yausername/dvd"
const val icons8 = "https://icons8.com/"
const val materialIcon = "https://fonts.google.com/icons"
const val materialColor = "https://github.com/material-foundation/material-color-utilities"
const val jetpack = "https://github.com/androidx/androidx"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreditsPage(onBackPressed: () -> Unit) {
    val decayAnimationSpec = rememberSplineBasedDecay<Float>()
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(
        decayAnimationSpec,
        rememberTopAppBarScrollState()
    )

    val creditsList = listOf(
        Credit("Android Jetpack", APACHE_V2, jetpack),
        Credit("youtubedl-android", GPL_V3, youtubedlAndroidUrl),
        Credit("yt-dlp", UNLICENSE, ytdlpUrl),
        Credit("Read You", GPL_V3, readYou),
//        Credit("Music You"),
        Credit("dvd", GPL_V3, dvd),
        Credit("Material Icons", APACHE_V2, materialIcon),
        Credit("Material color utilities", APACHE_V2, materialColor),
        Credit("App Icon", "Universal Multimedia Licensing Agreement for Icons8", icons8)
    )
    val uriHandler = LocalUriHandler.current
    fun openUrl(url: String) {
        uriHandler.openUri(url)
    }
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            LargeTopAppBar(
                title = {
                    Text(
                        modifier = Modifier.padding(start = 8.dp),
                        text = stringResource(id = R.string.credits),
                    )
                }, navigationIcon = {
                    IconButton(
                        modifier = Modifier.padding(start = 8.dp),
                        onClick = onBackPressed
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.ArrowBack,
                            contentDescription = stringResource(R.string.back)
                        )
                    }
                }, scrollBehavior = scrollBehavior
            )
        }, content = {
            LazyColumn(modifier = Modifier.padding(it)) {
                items(creditsList) { item ->
                    CreditItem(title = item.title, license = item.license) { openUrl(item.url) }
                }
            }
        })

}