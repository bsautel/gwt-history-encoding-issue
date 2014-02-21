This example project is aimed at reproducing the [#8546](http://code.google.com/p/google-web-toolkit/issues/detail?id=8546) GWT issue.

Compile and run this application. Click the anchor. It changes the history token. In Firefox, History.getToken() does not return the same value as in other browsers.