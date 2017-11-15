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
 ooyala.createPlayer(
     "wzaDkyOnVDlnaTV7ppH7GYvIBbXM", //pcode
     "12aXY5MTE6sGeOfdhAo_vEaqgajYwfRi",//ecode
     "http://www.ooyala.com", //url
     "cordova Ooyala test app",//title
     function(data){
                },
                function errorHandler(err){
                    console.log(err);
                    alert(JSON.stringify(err));

                });