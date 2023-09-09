# MobileDesign

## Getting Started

### create you emulator

```
sdkmanager --install "system-images;android-33;google_apis;x86_64"

avdmanager create avd -n Pixel_API_33 -k "system-images;android-33;google_apis;x86_64" -d 23

```

### start you emulator 

```emulator @Pixel_API_33```

### record your snapshot test case

```./gradlew mobile-design:debugExecuteScreenshotTests -Precord```


# Snapshot testing
| | | | | | | | | | | |
|-|-|-|-|-|-|-|-|-|-|-|
|common |![](app/screenshots/debug/com.nmg.mobiledesignlibrary.ColorItemScreenshotTests_test_color_Alert_snapshot.png)|![](app/screenshots/debug/com.nmg.mobiledesignlibrary.ColorItemScreenshotTests_test_color_Black_snapshot.png)|![](app/screenshots/debug/com.nmg.mobiledesignlibrary.ColorItemScreenshotTests_test_color_Success_snapshot.png)|![](app/screenshots/debug/com.nmg.mobiledesignlibrary.ColorItemScreenshotTests_test_color_White_snapshot.png)|
| WW Light |![](app/screenshots/debug/com.nmg.mobiledesignlibrary.ColorItemScreenshotTests_test_color_WW_snapshot.png)| | | | | | | | | | |
| MORE Light |![](app/screenshots/debug/com.nmg.mobiledesignlibrary.ColorItemScreenshotTests_test_color_MORE_snapshot.png)| | | | | | | | | | |
| ED Light |![](app/screenshots/debug/com.nmg.mobiledesignlibrary.ColorItemScreenshotTests_test_color_ED_snapshot.png)| | | | | | | | | | |
| KISS Light |![](app/screenshots/debug/com.nmg.mobiledesignlibrary.ColorItemScreenshotTests_test_color_KISS_snapshot.png)| | | | | | | | | | |
| NM Light |![](app/screenshots/debug/com.nmg.mobiledesignlibrary.ColorItemScreenshotTests_test_color_NM_snapshot.png)| | | | | | | | | | |
| OS Light |![](app/screenshots/debug/com.nmg.mobiledesignlibrary.ColorItemScreenshotTests_test_color_OS_snapshot.png)| | | | | | | | | | |
| GOTRIP Light |![](app/screenshots/debug/com.nmg.mobiledesignlibrary.ColorItemScreenshotTests_test_color_GOTRIP_snapshot.png)| | | | | | | | | | |

| | |
|-|-|
|commmon grey light|![](app/screenshots/debug/com.nmg.mobiledesignlibrary.ColorItemScreenshotTests_test_color_common.png)|

| | |
|-|-|
|typographies|![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_typographies.png) |
|body|![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_body.png) |
|bodyEmphasize|![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_bodyEmphasize.png) |
|caption|![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_caption.png) |
|caption2|![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_caption2.png) |
|caption3Emphasize|![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_caption3Emphasize.png) |
|captionEmphasize|![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_captionEmphasize.png) |
|headline|![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_headline.png) |
|headlineEmphasize|![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_headlineEmphasize.png) |
|largeTitleEmphasize|![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_largeTitleEmphasize.png) |
|naviTitle|![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_naviTitle.png) |
|primaryButton|![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_primaryButton.png) |
|title1|![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_title1.png) |
|title2|![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_title2.png) |
|title2Emphasize|![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_title2Emphasize.png) |
|title3|![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_title3.png) |
|title3Emphasize|![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_title3Emphasize.png) |
|title4|![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_title4.png) |
|title4Emphasize|![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_title4Emphasize.png) |
|title5|![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_title5.png) |
|titleEmphasize|![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.typographytest.TypographyTest_test_titleEmphasize.png)|

|component| |
|-|-|
|tabbar|![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.tabbartest.ChipGroupTest_test_ChipGroup.png)|
|card|![Alt text](mobile-design/screenshots/debug/com.nmg.mobile.design.cardview.CardViewTest_test_CardView.png)|



## target

- Pixel XL API 33








