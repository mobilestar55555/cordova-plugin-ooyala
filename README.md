---
title: Ooyala
description: Ooyala video streaming

INSTALL
========

```javascript
$ cordova create <PATH> [ID [NAME [CONFIG]]] [options]
$ cd <PATH>
$ cordova platform add android
$ cordova plugin add https://github.com/mobilestar55555/cordova-plugin-ooyala.git
```


USAGE:
======
```Setting with somethings manually
in build.gradle

dependencies {
    compile fileTree(include: '*.jar', dir: 'libs')
    compile project(':CastCompanionLibrary')
    compile 'com.google.android.exoplayer:exoplayer:r1.5.9'

    compile 'com.android.support:support-v4:25.3.1'
    compile 'com.android.support:appcompat-v7:25.3.1'
    // SUB-PROJECT DEPENDENCIES START
    debugCompile project(path: 'CordovaLib', configuration: 'debug')
    releaseCompile project(path: 'CordovaLib', configuration: 'release')
    // SUB-PROJECT DEPENDENCIES END
    compile(name: 'OoyalaCastSDK', ext: 'aar')
    compile(name: 'OoyalaSDK')
}

in settings.gradle
// GENERATED FILE - DO NOT EDIT
include ":CordovaLib"
include ':CastCompanionLibrary'
project(':CastCompanionLibrary').projectDir = new File(settingsDir, './CastCompanionLibrary')
```

```javascript
 ooyala.createPlayer(
     "xxxx", //pcode
     "xxxx",//ecode
     "http://www.ooyala.com", //url
     "cordova Ooyala test app",//title
     function(data){
    },
    function errorHandler(err){
        console.log(err);
        alert(JSON.stringify(err));

    });
```