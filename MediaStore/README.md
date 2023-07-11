Android 미디어 스토어 샘플
===========================

<사업부 정렬="센터">
<img src="screenshots/icon-web.png" height="256" alt="앱 아이콘"/>
</div>

이 샘플은 Android의 [MediaStore][4]를 사용하여 사용자를 찾고 표시하는 방법을 보여줍니다.
RecyclerView의 이미지.

소개
------------

이 샘플은 [Media Store][1]를 사용하여
[이미지][2] 컬렉션. 액세스하기 때문에 [`READ_EXTERNAL_STORAGE`][3] 권한이 필요합니다.
다른 앱이 만들고 Media Store에 기여한 파일.

전제 조건
--------------

- 안드로이드 SDK 29
- Android 기기/에뮬레이터 API 16+

스크린샷
-------------

<img src="screenshots/app.png" height="400" alt="스크린샷"/>

[Unsplash][5]에 있는 [Hannah Troupe][4]의 사진.

시작하기
---------------

이 샘플은 Gradle 빌드 시스템을 사용합니다. 이 프로젝트를 빌드하려면
"gradlew build" 명령을 사용하거나 Android Studio에서 "Import Project"를 사용하십시오.

지원하다
-------

- 스택 오버플로: http://stackoverflow.com/questions/tagged/android

이 샘플에서 오류를 발견한 경우 문제를 제출하세요.
https://github.com/android/storage/issues

패치가 권장되며 이 프로젝트를 포크하여 제출할 수 있습니다.
GitHub를 통해 풀 요청을 제출합니다. 자세한 내용은 CONTRIBUTING.md를 참조하십시오.

특허
-------

저작권 2019 Android Open Source Project, Inc.

한 명 이상의 기여자에 따라 ASF(Apache Software Foundation)에 라이선스 부여
라이센스 계약. 자세한 내용은 본 저작물과 함께 배포되는 NOTICE 파일을 참조하세요.
저작권 소유권에 관한 추가 정보. ASF는 이것을 허가합니다.
Apache 라이선스 버전 2.0("라이선스")에 따라 귀하에게 파일을 제출합니다. 당신은하지 않을 수 있습니다
라이센스를 준수하는 경우를 제외하고 이 파일을 사용하십시오. 사본을 얻을 수 있습니다.
라이선스는

http://www.apache.org/licenses/LICENSE-2.0

해당 법률에서 요구하거나 서면으로 동의하지 않는 한, 소프트웨어는
라이선스에 따라 배포되는 것은 "있는 그대로" 배포됩니다.
명시적이든 묵시적이든 모든 종류의 보증 또는 조건. 참조
아래의 권한 및 제한 사항을 관리하는 특정 언어에 대한 라이선스
라이센스.

[1]: https://developer.android.com/reference/android/provider/MediaStore
[2]: https://developer.android.com/reference/android/provider/MediaStore.Images
[3]: https://developer.android.com/reference/android/Manifest.permission.html#READ_EXTERNAL_STORAGE
[4]: https://developer.android.com/reference/android/provider/MediaStore
[5]: https://unsplash.com/@htroupe?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText

Android Media Store Sample
==========================

<div align="center">
<img src="screenshots/icon-web.png" height="256" alt="App Icon"/>
</div>

This sample demonstrates how to use Android's [MediaStore][4] to locate and display the users
images in a RecyclerView.

Introduction
------------

This sample demonstrates how to use the [Media Store][1] to display items in the
[Images][2] collection. This requires [`READ_EXTERNAL_STORAGE`][3] permission since it accesses
files that other apps created and contributed to the Media Store. 

Pre-requisites
--------------

- Android SDK 29
- Android Device/Emulator API 16+

Screenshots
-------------

<img src="screenshots/app.png" height="400" alt="Screenshot"/>

Photos by [Hannah Troupe][4] on [Unsplash][5].

Getting Started
---------------

This sample uses the Gradle build system. To build this project, use the
"gradlew build" command or use "Import Project" in Android Studio.

Support
-------

- Stack Overflow: http://stackoverflow.com/questions/tagged/android

If you've found an error in this sample, please file an issue:
https://github.com/android/storage/issues

Patches are encouraged, and may be submitted by forking this project and
submitting a pull request through GitHub. Please see CONTRIBUTING.md for more details.

License
-------

Copyright 2019 The Android Open Source Project, Inc.

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements.  See the NOTICE file distributed with this work for
additional information regarding copyright ownership.  The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License.  You may obtain a copy of
the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
License for the specific language governing permissions and limitations under
the License.

[1]: https://developer.android.com/reference/android/provider/MediaStore
[2]: https://developer.android.com/reference/android/provider/MediaStore.Images
[3]: https://developer.android.com/reference/android/Manifest.permission.html#READ_EXTERNAL_STORAGE
[4]: https://developer.android.com/reference/android/provider/MediaStore
[5]: https://unsplash.com/@htroupe?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText