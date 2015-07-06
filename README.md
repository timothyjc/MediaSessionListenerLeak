# MediaSessionListenerLeak


https://code.google.com/p/android/issues/detail?id=161398#makechanges

To reproduce, grant notification access under Settings then rotate screen several times.

LeakCanary Output:

In citc.testmediasessionlistener:1.0:1.
* citc.testmediasessionlistener.MainActivity has leaked:
* GC ROOT android.media.session.MediaSessionManager$SessionsChangedWrapper$1.this$1 (anonymous class extends android.media.session.IActiveSessionsListener$Stub)
* references android.media.session.MediaSessionManager$SessionsChangedWrapper.mListener
* references citc.testmediasessionlistener.MainActivity$1.this$0 (anonymous class implements android.media.session.MediaSessionManager$OnActiveSessionsChangedListener)
* leaks citc.testmediasessionlistener.MainActivity instance

* Reference Key: 93e6a60d-85d3-410d-9502-94f70693827c
* Device: LGE google Nexus 5 hammerhead
* Android Version: 5.1.1 API: 22 LeakCanary: 1.3.1
* Durations: watch=5128ms, gc=140ms, heap dump=1934ms, analysis=13889ms

* Details:
* Instance of android.media.session.MediaSessionManager$SessionsChangedWrapper$1
|   this$1 = android.media.session.MediaSessionManager$SessionsChangedWrapper [id=0x12dfc920]
|   mDescriptor = java.lang.String [id=0x7028eb18]
|   mObject = -1263646376
|   mOwner = android.media.session.MediaSessionManager$SessionsChangedWrapper$1 [id=0x12dfc940]
* Instance of android.media.session.MediaSessionManager$SessionsChangedWrapper
|   mHandler = android.os.Handler [id=0x12dfc900]
|   mListener = citc.testmediasessionlistener.MainActivity$1 [id=0x12dfb490]
|   mStub = android.media.session.MediaSessionManager$SessionsChangedWrapper$1 [id=0x12dfc940]
|   this$0 = android.media.session.MediaSessionManager [id=0x12dfc8c0]
* Instance of citc.testmediasessionlistener.MainActivity$1
|   this$0 = citc.testmediasessionlistener.MainActivity [id=0x12d0c1c0]
* Instance of citc.testmediasessionlistener.MainActivity
|   static $staticOverhead = byte[] [id=0x12d0a001;length=8;size=24]
|   static TAG = java.lang.String [id=0x12cf0ca0]
|   mListener = citc.testmediasessionlistener.MainActivity$1 [id=0x12dfb490]
|   mDelegate = android.support.v7.app.AppCompatDelegateImplV14 [id=0x12c324e0]
|   mAllLoaderManagers = android.support.v4.util.SimpleArrayMap [id=0x12dfc8a0]
|   mCheckedForLoaderManager = true
|   mContainer = android.support.v4.app.FragmentActivity$2 [id=0x12ddbd60]
|   mCreated = true
|   mFragments = android.support.v4.app.FragmentManagerImpl [id=0x12ddcba0]
|   mHandler = android.support.v4.app.FragmentActivity$1 [id=0x12df1280]
|   mLoaderManager = null
|   mLoadersStarted = false
|   mOptionsMenuInvalidated = false
|   mReallyStopped = true
|   mResumed = false
|   mRetaining = true
|   mStopped = true
|   mActionBar = null
|   mActivityInfo = android.content.pm.ActivityInfo [id=0x12c26200]
|   mActivityTransitionState = android.app.ActivityTransitionState [id=0x12deed80]
|   mAllLoaderManagers = android.util.ArrayMap [id=0x12dfc880]
|   mApplication = citc.testmediasessionlistener.MyApp [id=0x12c7c660]
|   mCalled = true
|   mChangeCanvasToTranslucent = false
|   mChangingConfigurations = true
|   mCheckedForLoaderManager = true
|   mComponent = android.content.ComponentName [id=0x12c690e0]
|   mConfigChangeFlags = 1152
|   mContainer = android.app.Activity$1 [id=0x12ddbd30]
|   mCurrentConfig = android.content.res.Configuration [id=0x12de85e0]
|   mDecor = null
|   mDefaultKeyMode = 0
|   mDefaultKeySsb = null
|   mDestroyed = true
|   mDoReportFullyDrawn = false
|   mEmbeddedID = null
|   mEnableDefaultActionBarUp = false
|   mEnterTransitionListener = android.app.SharedElementCallback$1 [id=0x709ab7f8]
|   mExitTransitionListener = android.app.SharedElementCallback$1 [id=0x709ab7f8]
|   mFinished = false
|   mFragments = android.app.FragmentManagerImpl [id=0x12ddcb30]
|   mHandler = android.os.Handler [id=0x12df1260]
|   mIdent = 902150269
|   mInstanceTracker = android.os.StrictMode$InstanceTracker [id=0x12ddbd40]
|   mInstrumentation = android.app.Instrumentation [id=0x12c7b060]
|   mIntent = android.content.Intent [id=0x12c761c0]
|   mLastNonConfigurationInstances = null
|   mLoaderManager = null
|   mLoadersStarted = false
|   mMainThread = android.app.ActivityThread [id=0x12c35100]
|   mManagedCursors = java.util.ArrayList [id=0x12df1240]
|   mManagedDialogs = null
|   mMenuInflater = null
|   mParent = null
|   mReferrer = null
|   mResultCode = 0
|   mResultData = null
|   mResumed = false
|   mSearchManager = null
|   mStartedActivity = false
|   mStopped = true
|   mTemporaryPause = false
|   mTitle = java.lang.String [id=0x12d13060]
|   mTitleColor = 0
|   mTitleReady = true
|   mToken = android.os.BinderProxy [id=0x12c67c80]
|   mTranslucentCallback = null
|   mUiThread = java.lang.Thread [id=0x73b5b000]
|   mVisibleBehind = false
|   mVisibleFromClient = true
|   mVisibleFromServer = true
|   mVoiceInteractor = null
|   mWindow = com.android.internal.policy.impl.PhoneWindow [id=0x12d14980]
|   mWindowAdded = true
|   mWindowManager = android.view.WindowManagerImpl [id=0x12df1480]
|   mInflater = com.android.internal.policy.impl.PhoneLayoutInflater [id=0x12df05b0]
|   mOverrideConfiguration = null
|   mResources = android.content.res.Resources [id=0x12c0b8e0]
|   mTheme = android.content.res.Resources$Theme [id=0x12df14a0]
|   mThemeResource = 2131230840
|   mBase = android.app.ContextImpl [id=0x12dd5600]
