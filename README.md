This example project is aimed at reproducing the issue [#8546](http://code.google.com/p/google-web-toolkit/issues/detail?id=8546) of GWT.

Compile and run this application. Click the anchor. It changes the history token. In Firefox, History.getToken() does not return the same value as in other browsers.