# MobileDesign

## Getting Started

Read it first https://github.com/pedrovgs/Shot

### create your emulator

```
sdkmanager --install "system-images;android-28;google_apis;x86"

avdmanager create avd -n Pixel_API_28 -k "system-images;android-28;google_apis;x86" -d 23

```

# Update Config.ini

<path to>/.android/avd/Pixel_API_28.avd/config.ini

```
AvdId = Pixel_API_28
PlayStore.enabled = true
abi.type = x86
avd.ini.displayname = Pixel API 28
avd.ini.encoding = UTF-8
disk.dataPartition.size = 6442450944
fastboot.chosenSnapshotFile = 
fastboot.forceChosenSnapshotBoot = no
fastboot.forceColdBoot = yes
fastboot.forceFastBoot = no
hw.accelerometer = yes
hw.arc = false
hw.audioInput = yes
hw.battery = yes
hw.camera.back = virtualscene
hw.camera.front = emulated
hw.cpu.arch = x86
hw.cpu.ncore = 4
hw.dPad = no
hw.device.hash2 = MD5:55acbc835978f326788ed66a5cd4c9a7
hw.device.manufacturer = Google
hw.device.name = pixel
hw.gps = yes
hw.gpu.enabled = yes
hw.gpu.mode = auto
hw.initialOrientation = Portrait
hw.keyboard = yes
hw.lcd.density = 420
hw.lcd.height = 1920
hw.lcd.width = 1080
hw.mainKeys = no
hw.ramSize = 1536
hw.sdCard = yes
hw.sensors.orientation = yes
hw.sensors.proximity = yes
hw.trackBall = no
runtime.network.latency = none
runtime.network.speed = full
sdcard.size = 512M
showDeviceFrame = no
skin.dynamic = yes
skin.name = 1080x1920
skin.path = _no_skin
tag.display = Google Play
tag.id = google_apis_playstore
vm.heapSize = 228

```

### start your emulator

`emulator @Pixel_API_28`

read more: [Installing and creating Emulators with AVDMANAGER (For Continuous Integration Server or Local Use)](https://gist.github.com/mrk-han/66ac1a724456cadf1c93f4218c6060ae?permalink_comment_id=3648957)

### record your snapshot test case

- All Test
  - `./gradlew mobile-design:debugExecuteScreenshotTests -Precord`

- Single Test 
  - `./gradlew mobile-design:debugExecuteScreenshotTests -Precord -Pandroid.testInstrumentationRunnerArguments.class=com.nmg.mobile.design.widgets.videoplayer.VideoPlayerControlTest`


# Snapshot testing
| | | | | | | |
|-|-|-|-|-|-|-|
| common       | ![](app/screenshots/debug/com.nmg.mobiledesignlibrary.ColorItemScreenshotTests_test_color_Alert_snapshot.png)   | ![](app/screenshots/debug/com.nmg.mobiledesignlibrary.ColorItemScreenshotTests_test_color_Black_snapshot.png) | ![](app/screenshots/debug/com.nmg.mobiledesignlibrary.ColorItemScreenshotTests_test_color_Success_snapshot.png) | ![](app/screenshots/debug/com.nmg.mobiledesignlibrary.ColorItemScreenshotTests_test_color_White_snapshot.png) |     |     |     |     |     |     |     |
| WW Light     | ![](mobile-design/screenshots/debug/com.nmg.mobile.design.colorstest.ColorsTest_test_color_ww_snapshot.png)     |                                                                                                               |                                                                                                                 |                                                                                                               |     |     |     |     |     |     |     |
| MORE Light   | ![](mobile-design/screenshots/debug/com.nmg.mobile.design.colorstest.ColorsTest_test_color_more_snapshot.png)   |                                                                                                               |                                                                                                                 |                                                                                                               |     |     |     |     |     |     |     |
| ED Light     | ![](mobile-design/screenshots/debug/com.nmg.mobile.design.colorstest.ColorsTest_test_color_ed_snapshot.png)     |                                                                                                               |                                                                                                                 |                                                                                                               |     |     |     |     |     |     |     |
| KISS Light   | ![](mobile-design/screenshots/debug/com.nmg.mobile.design.colorstest.ColorsTest_test_color_kiss_snapshot.png)   |                                                                                                               |                                                                                                                 |                                                                                                               |     |     |     |     |     |     |     |
| NM Light     | ![](mobile-design/screenshots/debug/com.nmg.mobile.design.colorstest.ColorsTest_test_color_nm_snapshot.png)     |                                                                                                               |                                                                                                                 |                                                                                                               |     |     |     |     |     |     |     |
| OS Light     | ![](mobile-design/screenshots/debug/com.nmg.mobile.design.colorstest.ColorsTest_test_color_os_snapshot.png)     |                                                                                                               |                                                                                                                 |                                                                                                               |     |     |     |     |     |     |     |
| GOTRIP Light | ![](mobile-design/screenshots/debug/com.nmg.mobile.design.colorstest.ColorsTest_test_color_gotrip_snapshot.png) |                                                                                                               |                                                                                                                 |                                                                                                               |     |     |     |     |     |     |     |
| OH Light     | ![](mobile-design/screenshots/debug/com.nmg.mobile.design.colorstest.ColorsTest_test_color_oh_snapshot.png)     |                                                                                                               |                                                                                                                 |                                                                                                               |     |     |     |     |     |     |     |

|                    |                                                                                                        |
| ------------------ | ------------------------------------------------------------------------------------------------------ |
| commmon grey light | ![](mobile-design/screenshots/debug/com.nmg.mobile.design.colorstest.ColorsTest_test_color_common.png) |

|                     |                                                                                                                               |
| ------------------- | ----------------------------------------------------------------------------------------------------------------------------- |
| typographies        | ![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_typographies.png)        |
| body                | ![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_body.png)                |
| bodyEmphasize       | ![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_bodyEmphasize.png)       |
| caption             | ![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_caption.png)             |
| caption2            | ![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_caption2.png)            |
| caption3Emphasize   | ![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_caption3Emphasize.png)   |
| captionEmphasize    | ![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_captionEmphasize.png)    |
| headline            | ![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_headline.png)            |
| headlineEmphasize   | ![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_headlineEmphasize.png)   |
| largeTitleEmphasize | ![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_largeTitleEmphasize.png) |
| naviTitle           | ![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_naviTitle.png)           |
| primaryButton       | ![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_primaryButton.png)       |
| title1              | ![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_title1.png)              |
| title2              | ![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_title2.png)              |
| title2Emphasize     | ![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_title2Emphasize.png)     |
| title3              | ![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_title3.png)              |
| title3Emphasize     | ![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_title3Emphasize.png)     |
| title4              | ![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_title4.png)              |
| title4Emphasize     | ![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_title4Emphasize.png)     |
| title5              | ![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_title5.png)              |
| titleEmphasize      | ![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_titleEmphasize.png)      |

| component             |                                                                                                                                                                                                                                              |
|-----------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| chip group            | ![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.chipgrouptest.ChipGroupTest_test_ChipGroup.png)                                                                                                                            |
| card                  | ![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.cardview.CardViewTest_test_CardView.png)                                                                                                                                   |
| video player control  | ![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.videoplayer.VideoPlayerControlTest_test_VideoPlayerControlTest_LOADING.png)                                                                                              |
|                       | ![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.videoplayer.VideoPlayerControlTest_test_VideoPlayerControlTest_PLAYING.png)                                                |
|                       | ![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.videoplayer.VideoPlayerControlTest_test_VideoPlayerControlTest_PLAYING_TAB.png) |
|                       | ![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.videoplayer.VideoPlayerControlTest_test_VideoPlayerControlTest_PAUSED.png)        |
|                       | ![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.videoplayer.VideoPlayerControlTest_test_VideoPlayerControlTest_COMPLETED.png)          |
|                       | ![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.videoplayer.VideoPlayerControlTest_test_VideoPlayerControlTest_COMPLETED_CANCEL_AUTOPLAY.png)        |
| ReelActionButton      | ![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.reel.ReelActionButtonTest_test_ReelActionButton.png)         |
| ReelActionButtonGroup | ![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.reel.ReelActionButtonGroupTest_test_ReelActionButtonGroup.png)         |
| ReelPlayer            | ![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.reel.ReelPlayerTest_test_ReelPlayer.png)                                                                                                                                  |
| ReelPager             | ![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.reel.ReelPagerTest_test_ReelPager.png)                                                                                                                                  |

## target

- Pixel XL API 28
