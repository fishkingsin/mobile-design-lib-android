# MobileDesign

## Getting Started

Read it first https://github.com/pedrovgs/Shot

### create your emulator

```
sdkmanager --install "system-images;android-33;google_apis;x86_64"

avdmanager create avd -n Pixel_API_33 -k "system-images;android-33;google_apis;x86_64" -d 23

```

### start your emulator

`emulator @Pixel_API_33`

read more: [Installing and creating Emulators with AVDMANAGER (For Continuous Integration Server or Local Use)](https://gist.github.com/mrk-han/66ac1a724456cadf1c93f4218c6060ae?permalink_comment_id=3648957)

### record your snapshot test case

`./gradlew mobile-design:debugExecuteScreenshotTests -Precord`

# Snapshot testing

| | | | | | | |
|-|-|-|-|-|-|-|
| common       | ![](app/screenshots/debug/com.nmg.mobiledesignlibrary.ColorItemScreenshotTests_test_color_Alert_snapshot.png)    | ![](app/screenshots/debug/com.nmg.mobiledesignlibrary.ColorItemScreenshotTests_test_color_Black_snapshot.png) | ![](app/screenshots/debug/com.nmg.mobiledesignlibrary.ColorItemScreenshotTests_test_color_Success_snapshot.png) | ![](app/screenshots/debug/com.nmg.mobiledesignlibrary.ColorItemScreenshotTests_test_color_White_snapshot.png) |
| WW Light     | ![](mobile-design/screenshots/debug/com.nmg.mobile.design.colorstest.ColorsTest_test_color_ww_snapshot.png)       |                                                                                                               |                                                                                                                 |                                                                                                               |     |     |     |     |     |     |     |
| MORE Light   | ![](mobile-design/screenshots/debug/com.nmg.mobile.design.colorstest.ColorsTest_test_color_more_snapshot.png)     |                                                                                                               |                                                                                                                 |                                                                                                               |     |     |     |     |     |     |     |
| ED Light     | ![](mobile-design/screenshots/debug/com.nmg.mobile.design.colorstest.ColorsTest_test_color_ed_snapshot.png)       |                                                                                                               |                                                                                                                 |                                                                                                               |     |     |     |     |     |     |     |
| KISS Light   | ![](mobile-design/screenshots/debug/com.nmg.mobile.design.colorstest.ColorsTest_test_color_kiss_snapshot.png)     |                                                                                                               |                                                                                                                 |                                                                                                               |     |     |     |     |     |     |     |
| NM Light     | ![](mobile-design/screenshots/debug/com.nmg.mobile.design.colorstest.ColorsTest_test_color_nm_snapshot.png)       |                                                                                                               |                                                                                                                 |                                                                                                               |     |     |     |     |     |     |     |
| OS Light     | ![](mobile-design/screenshots/debug/com.nmg.mobile.design.colorstest.ColorsTest_test_color_os_snapshot.png) |                                                                                                               |                                                                                                                 |                                                                                                               |     |     |     |     |     |     |     |
| GOTRIP Light  | ![](mobile-design/screenshots/debug/com.nmg.mobile.design.colorstest.ColorsTest_test_color_gotrip_snapshot.png)   |                                                                                                               |                                                                                                                 |                                                                                                               |     |     |     |     |     |     |     |
| OH Light  | ![](mobile-design/screenshots/debug/com.nmg.mobile.design.colorstest.ColorsTest_test_color_oh_snapshot.png)   |                                                                                                               |                                                                                                                 |                                                                                                               |     |     |     |     |     |     |     |

|                    |                                                                                                       |
| ------------------ | ----------------------------------------------------------------------------------------------------- |
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

| component            |                                                                                                                                                                                                                                               |
|----------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| chip group           | ![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.chipgrouptest.ChipGroupTest_test_ChipGroup.png)                                                                                                                             |
| card                 | ![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.cardview.CardViewTest_test_CardView.png)                                                                                                                                    |
| video player control | ![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.videoplayer.VideoPlayerControlTest_test_VideoPlayerControlTest_LOADING.png)                                                                                               |
|  | ![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.videoplayer.VideoPlayerControlTest_test_VideoPlayerControlTest_PLAYING.png)                                                 |
|  | ![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.videoplayer.VideoPlayerControlTest_test_VideoPlayerControlTest_PLAYING_TAB.png) |
|  | ![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.videoplayer.VideoPlayerControlTest_test_VideoPlayerControlTest_PAUSED.png)         |
|  | ![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.videoplayer.VideoPlayerControlTest_test_VideoPlayerControlTest_COMPLETED.png)           |
|  | ![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.videoplayer.VideoPlayerControlTest_test_VideoPlayerControlTest_COMPLETED_CANCEL_AUTOPLAY.png)         |

## target

- Pixel XL API 33
