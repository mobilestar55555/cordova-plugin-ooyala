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