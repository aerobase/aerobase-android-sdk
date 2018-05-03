# Contributing to the Aerobase Android SDK

The Aerobase Android SDK is part of the [Aerobase project](http://aerobase.org/), see the [Community Page](http://aerobase.org/community) for general guidelines for contributing to the project.

This document details specifics for contributions to the Android SDK.

## Issue tracker

The tracking of issues for the AeroGear Android SDK is done in the [Aerobase Android Project](https://aerobase.atlassian.net/projects/ARBDROID/issues).

See the [Aerobase JIRA Usage and Guidelines Guide](https://aerobase.atlassian.net/wiki/) for information on how the issue tracker relates to contributions to this project.

## Asking for help

Whether you're contributing a new feature or bug fix, or simply submitting a
ticket, the Aerobase team is available for technical advice or feedback. 
You can reach us at [@AerobaseOrg] or at the 
[aerobase google group](https://groups.google.com/forum/#!forum/aerobase)
-- both are actively monitored.

# Developing the Android SDK

## Prerequisites

Ensure you have the following installed in your machine:

- [Java Development Kit](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html)
- [Android Studio and Android SDK](https://developer.android.com/studio/index.html)
- [Git SCM](http://git-scm.com/)

## Cloning the repository

```bash
git clone https://github.com/aerobase/aerobase-android-sdk.git
cd aerobase-android-sdk/
```

## Installing dependencies and building the SDK

Run the following command to install the dependencies for the Android SDK:

```bash
./gradlew install
```

In Android Studio, go to `Tools > Android > Sync Project With Gradle Files`.

See the [Gradle Documentation](https://docs.gradle.org/current/userguide/pt02.html) for more information on Gradle and the Gradle Wrapper

## Adding Our Style Guide to Android Studio

We are using spotless to enforce our style guidelines on the project.  You may invoke spotless manually by running `./gradlew spotlessCheck`.  If there are errors spotless will prompt you to run `./gradlew spotlessApply` and auto fix them.  If your code fails to meet the style guidelines it will fail.  However, if you are using Android Studio you may make use of the [Eclipse Code Formatter](http://plugins.jetbrains.com/plugin/6546-eclipse-code-formatter).

## Publish to maven repo 
- Make sure \~/.gradle/gradle.properties file exists with the following entries:
```bash
NEXUS_USERNAME=Your Nexus user name
NEXUS_PASSWORD=Your Nexus password
signing.keyId=You can use gpg -K to get it
signing.password=The passphrase used to protect your private key
signing.secretKeyRingFile=~/.gnupg/secring.gpg
```

For further signing plugin details refer to https://docs.gradle.org/current/userguide/signing_plugin.html
