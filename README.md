MapChangeDemo
=============

The project shows how to integrate the [MapChangeLibrary][1] into a project
using a namespace other then the library project.

The project has been set up to work with Maven as well as with IDEs such as
Eclipse, IntelliJ or Android Studio.


Screenshot
----------

The screenshot shows the current implementation.

![MapChangeDemo](https://github.com/johnjohndoe/MapChangeDemo/raw/master/screenshot.png "MapChangeDemo")


Configuration
-------------

Please make sure to enter your private Google Maps API key before running the
application. If you forget to do so the map will not be shown. To enter the
key edit the `apikeys.xml` file in `/res/values` to add a value for `google_maps_api_key`:

    google_maps_api_key="ENTER_GOOGLE_MAPS_API_KEY_HERE"

License
-------

This work is licensed under a [Creative Commons Attribution-ShareAlike 3.0 Unported License][2].

![Creative Commons Attribution-ShareAlike 3.0 Unported License](http://i.creativecommons.org/l/by-sa/3.0/88x31.png "Creative Commons Attribution-ShareAlike 3.0 Unported License")


[1]: https://github.com/johnjohndoe/MapChange/commit/e48fdfd0d3683994c458a26993a249061d9bf3b1
[2]: http://creativecommons.org/licenses/by-sa/3.0/
