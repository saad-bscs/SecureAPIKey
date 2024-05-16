Protect API key from Reverse engineering.

Steps to follow: 

1- Open local.properties which is located under root directory. Add new key-value entry for your API key in it. for example,
USER_LOGIN = /login

2- local.properties file is a file that is ignored while commit or push to version control. Its a file“something you don’t want to share” by default .
To verify, check .gitignore file. (if it isn’t there, make sure to add it.)

Check local.properties present in gitignore file.

3- Now make this key available to use it as variable. Open build.gradle(app) and write below lines of code

Below code for build.gradle file

Properties properties = new Properties()
properties.load(project.rootProject.file('local.properties').newDataInputStream())

buildConfigField "String", "USER_LOGIN", "\"${properties.getProperty('USER_LOGIN')}\""

In newer versions of android studio, build.gradle.kts file is present, so the code will be like this,

val properties = Properties()
properties.load(project.rootProject.file("local.properties").inputStream())

buildConfigField("String", "USER_LOGIN", "\"${properties.getProperty("USER_LOGIN")}\"")
buildConfigField("String", "USER_PASSWORD", "\"${properties.getProperty("USER_PASSWORD")}\"")

And then, Sync the project.

4- Make Project from build section which is present in toolbar

4.1- Extra point, its possible that you encountered a problem like defaultConfig contains custom BuildConfig fields, but the feature is disabled.
To enable the feature, add the following to your module-level build.gradle:

buildFeatures {
buildConfig = true
}

It will resolve the issue.

5- After build is completed, now API key will be accessible as a build config variable from any class like below:

val apiKey = BuildConfig.USER_LOGIN

That's it from my side. Keep learning.
