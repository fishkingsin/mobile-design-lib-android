package com.nmg.mobile.design.widgets.videoplayer

import android.net.Uri
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.nmg.mobile.design.R
import com.nmg.mobile.design.theme.NMGTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

@Composable
public fun VideoPlayerControl(
    data: VideoPlayerControlData,
    event: VideoPlayerControlEvent? = null,
    onVideoPlayerLayer: (@Composable (BoxScope) -> Unit)? = null,
    onVideoPlayerCompletedLayer: (@Composable (BoxScope) -> Unit)? = null,
    playState: VideoPlayerControlState = VideoPlayerControlState.LOADING,
    progressValue: Float = 0f,
) {
    Box(
        modifier = Modifier
            .aspectRatio(390f / 219f)
            .size(390.dp, 219.dp)
            .background(Color.Black)
            .clickable(enabled = true, onClick = {
                if (playState == VideoPlayerControlState.PLAYING) {
                    event?.onClickVideoWhenPlaying()
                }
            })
    ) {
        onVideoPlayerLayer?.let { it ->
            it(this)
        }
        when (playState) {
            VideoPlayerControlState.LOADING -> {
                VideoPlayerControlInitView(boxScope = this, data = data)
            }

            VideoPlayerControlState.PLAYING -> {
                VideoPlayerControlPlayingView(boxScope = this, sliderValue = progressValue)
            }

            VideoPlayerControlState.PLAYING_TAB, VideoPlayerControlState.PAUSED, VideoPlayerControlState.COMPLETED_CANCEL_AUTOPLAY -> {
                VideoPlayerControlPlayingTabOrPauseOrCompletedView(
                    boxScope = this,
                    videoPlayerControlState = playState,
                    event = event
                )
                VideoPlayerControlPlayingView(boxScope = this, sliderValue = data.sliderValue)
            }

            VideoPlayerControlState.COMPLETED -> {
                onVideoPlayerCompletedLayer?.let { it ->
                    it(this)
                }
            }

            else -> {
                Text(text = "UNKNOWN STATE")
            }
        }
    }
}

@Composable
fun VideoPlayerControlInitView(boxScope: BoxScope, data: VideoPlayerControlData) {
    boxScope.apply {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current).data(data.imageURL)
                .crossfade(true).build(),
            placeholder = painterResource(R.drawable.placeholder),
            contentDescription = stringResource(R.string.description),
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .background(
                    color = Color.Black,
                    shape = RoundedCornerShape(4.dp)
                )
                .fillMaxSize()
                .aspectRatio(390f / 219f)
                .size(390.dp, 219.dp)
        )
        Row(
            modifier = Modifier.align(Alignment.Center),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(enabled = false, onClick = {}) {
                Icon(
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp),
                    tint = Color.White,
                    painter = painterResource(id = R.drawable.video_player_loading),
                    contentDescription = ""
                )
            }
        }
    }
}

@Composable
fun VideoPlayerControlPlayingView(boxScope: BoxScope, sliderValue: Float) {
    Log.i("progress", "VideoPlayerControlPlayingView#sliderValue ${sliderValue}")
    boxScope.apply {
        Slider(
            modifier = Modifier
                .fillMaxWidth()
                .height(3.dp)
                .align(Alignment.BottomCenter),
            value = sliderValue,
            onValueChange = { itValue ->
                Log.i("progress", "onValueChange#itValue ${itValue}")
            },
            onValueChangeFinished = {
                // launch some business logic update with the state you hold
                // viewModel.updateSelectedSliderValue(sliderPosition)
                Log.i("progress", "onValueChangeFinished")

            },
            colors = SliderDefaults.colors(
                thumbColor = NMGTheme.colors.primaryMain,
                activeTrackColor = NMGTheme.colors.primaryMain,
                inactiveTrackColor = Color.White
            )
        )
    }
}

@Composable
fun VideoPlayerControlPlayingTabOrPauseOrCompletedView(
    boxScope: BoxScope,
    videoPlayerControlState: VideoPlayerControlState,
    event: VideoPlayerControlEvent? = null
) {
    boxScope.apply {
        Row(
            modifier = Modifier.align(Alignment.Center),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { event?.onClickPre() }) {
                Icon(
                    modifier = Modifier
                        .width(44.dp)
                        .height(44.dp),
                    tint = Color.White,
                    painter = painterResource(id = R.drawable.video_player_pre),
                    contentDescription = ""
                )
            }
            Spacer(modifier = Modifier.width(32.dp))
            IconButton(onClick = {
                when (videoPlayerControlState) {
                    VideoPlayerControlState.PLAYING_TAB -> event?.onClickPause()
                    VideoPlayerControlState.PAUSED -> event?.onClickPlay()
                    VideoPlayerControlState.COMPLETED -> event?.onClickReplay()
                    else -> {
                        // pass
                    }
                }
            }) {
                when (videoPlayerControlState) {
                    VideoPlayerControlState.PLAYING_TAB -> {
                        Icon(
                            modifier = Modifier
                                .width(60.dp)
                                .height(60.dp),
                            tint = Color.White,
                            painter = painterResource(id = R.drawable.video_player_pause),
                            contentDescription = ""
                        )
                    }

                    VideoPlayerControlState.PAUSED -> {
                        Icon(
                            modifier = Modifier
                                .width(60.dp)
                                .height(60.dp),
                            tint = Color.White,
                            painter = painterResource(id = R.drawable.video_player_play),
                            contentDescription = ""
                        )
                    }

                    VideoPlayerControlState.COMPLETED_CANCEL_AUTOPLAY -> {
                        Icon(
                            modifier = Modifier
                                .width(60.dp)
                                .height(60.dp),
                            tint = Color.White,
                            painter = painterResource(id = R.drawable.video_player_replay),
                            contentDescription = ""
                        )
                    }

                    else -> {}
                }
            }
            Spacer(modifier = Modifier.width(32.dp))
            IconButton(onClick = { event?.onClickNext() }) {
                Icon(
                    modifier = Modifier
                        .width(44.dp)
                        .height(44.dp),
                    tint = Color.White,
                    painter = painterResource(id = R.drawable.video_player_next),
                    contentDescription = ""
                )
            }
        }

        if (VideoPlayerControlState.PAUSED == videoPlayerControlState ||
            VideoPlayerControlState.PLAYING == videoPlayerControlState ||
            VideoPlayerControlState.PLAYING_TAB == videoPlayerControlState
        ) {
            IconButton(
                onClick = { event?.onClickFullScreen() },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
            ) {
                Icon(
                    modifier = Modifier
                        .padding(16.dp)
                        .width(16.dp)
                        .height(16.dp),
                    tint = Color.White,
                    painter = painterResource(id = R.drawable.video_player_expand),
                    contentDescription = ""
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VideoPlayerControlPreview() {
    var playState by remember {
        mutableStateOf(VideoPlayerControlState.LOADING)
    }
//    val interactions = remember { mutableStateListOf<Interaction>() }
    var onClickPlay: MutableSharedFlow<Unit?> = MutableSharedFlow()
    var onClickPause: MutableSharedFlow<Unit?> = MutableSharedFlow()
    val testUri =
//        Uri.parse("https://demo.unified-streaming.com/k8s/features/stable/video/tears-of-steel/tears-of-steel.ism/.m3u8")
        Uri.parse("https://cdn.theoplayer.com/video/big_buck_bunny/big_buck_bunny.m3u8")
//        Uri.parse("http://qthttp.apple.com.edgesuite.net/1010qwoeiuryfg/sl.m3u8")
    // Define the UI element expanded state
    var item: VideoPlayerControlData = object : VideoPlayerControlData {
        override var playState = VideoPlayerControlState.LOADING
        override var imageURL: String = "https://placehold.co/390x219/png"
        override var totalTime: String = "22:22"
        override var sliderValue by remember {
            mutableStateOf(0f)
        }
    }

//    CoroutineScope(Dispatchers.IO).launch {
//        onClickPlay.collect {
//            Log.d("AAA", "onCreate: $it => Kotlin.Unit")
//        }
//    }
    NMGTheme {
        LaunchedEffect(Unit) {
            onClickPlay.collect {
                Log.i("VideoPlayerControl", "onClickPlay ${onClickPlay}")
            }
        }
        LaunchedEffect(Unit) {
            onClickPause.collect {
                Log.i("VideoPlayerControl", "onClickPause ${onClickPause}")
            }
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(NMGTheme.customSystem.padding)
        ) {
            VideoPlayerControl(
                playState = playState,
                data = item,
                onVideoPlayerLayer = {
                    VideoPlayer(
                        uri = testUri,
                        isAutoPlay = true,
                        onStateChange = { itState ->
                            Log.i(
                                "VideoPlayerControl",
                                "[VideoPlayer]VideoPlayer#itState=$itState"
                            )
                            playState = itState
                        },
//                        clickPlayEvent = null,
//                        clickPauseEvent = null
//                        onClickedPlay = onClickPlay,
//                        onClickedPause = onClickPause,
                    )
                },
                event = object : VideoPlayerControlEvent {
                    override fun onClickPlay() {
                            playState = VideoPlayerControlState.PLAYING
                            Log.i("VideoPlayerControl", "emit onClickPlay")
                        onClickPlay.tryEmit(Unit)
//                            onClickPlay = (Unit)
//                            onClickPlay = null
                        }

                    override fun onClickPause() {
                            playState = VideoPlayerControlState.PAUSED
                            Log.i("VideoPlayerControl", "emit onClickPause")
                        onClickPause.tryEmit(Unit)
//                            onClickPause = (Unit)
//                            onClickPause = null
                        }

                    override fun onClickVideoWhenPlaying() {
                        Log.i("VideoPlayerControl", "emit onClickVideoWhenPlaying")
                        playState = VideoPlayerControlState.PLAYING_TAB
                    }
                },
            )
        }
    }
}


class MyViewModel : ViewModel() {
    var _clickEvent: MutableSharedFlow<Unit?> = MutableSharedFlow()
    var clickEvent: SharedFlow<Unit?> = _clickEvent
    fun onClick() {
        viewModelScope.launch {
            _clickEvent.emit(Unit)
        }
    }
}

@Composable
fun Greeting(
    viewModel: MyViewModel = MyViewModel()
) {
    SubView(viewModel.clickEvent, viewModel::onClick)

}

@Composable
fun SubView(
    clickEvent: Flow<Unit?>? = null,
    callBack: () -> Unit = { println("callBack") }
) {
    LaunchedEffect(Unit) {
        clickEvent?.collect { e ->
            println("clickEvent=$e")
        }
    }

    Button(
        onClick = { callBack() },
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(text = "Button")
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
        Greeting()
}