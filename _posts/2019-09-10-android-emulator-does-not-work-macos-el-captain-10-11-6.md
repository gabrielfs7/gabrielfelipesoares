---
title: Emulate Android on Android Studio 3 using Mac OSX El Captain 10.11.6
categories:
- Android
- MacOs
feature_image: "https://picsum.photos/2560/600?image=872"
---

If you are having problems to emulate Android using Mac OSX El Captain 10.11.6, may this can help you.

<!-- more -->


If when trying to run the emulation you got the following message:

``` js
Emulator: Sorry, "qemu-system-x86_64" can not be run on this version of macOS. Qt requires macOS 10.12.0 or later, you have macOS 10.11.6.
```

The solution can be downgrad your emulator version to [Android Emulator Version 28.0.25](https://dl.google.com/android/repository/emulator-darwin-5395263.zip).


After download you should replace your current emulator with this one. The emulator for **Android Studio** generally is located on:

``` js 
/Users/{YOUR_USERNAME}/Library/Android/sdk/emulator

```

So you can just replace the files and restart your Android studio.