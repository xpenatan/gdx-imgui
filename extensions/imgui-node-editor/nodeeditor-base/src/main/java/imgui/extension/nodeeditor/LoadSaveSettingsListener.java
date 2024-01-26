package imgui.extension.nodeeditor;

import imgui.idl.IDLBase;
import imgui.idl.helper.IDLString;

public abstract class LoadSaveSettingsListener extends IDLBase {

        /*[-C++;-NATIVE]
        static jclass loadSaveSettingsListenerClass = 0;
        static jmethodID onLoadID = 0;
        static jmethodID onSaveID = 0;
        class LoadSaveSettingsListenerImpl : public LoadSaveSettingsListener
        {
        private:
            JNIEnv* env;
            jobject obj;
        public:
            LoadSaveSettingsListenerImpl( JNIEnv* env, jobject obj )
            {
                this->env = env;
                this->obj = obj;
            }
            virtual void onLoad(std::string* data)
            {
                env->CallVoidMethod(obj, onLoadID, (jlong)data);
            }
            virtual bool onSave(std::string* data, ax::NodeEditor::SaveReasonFlags reason)
            {
                return env->CallBooleanMethod(obj, onSaveID, (jlong)data, (jint)reason);
            }
        };
    */

    /*[-teaVM;-ADD]
        @org.teavm.jso.JSFunctor
        public interface OnLoad extends org.teavm.jso.JSObject {
            void onLoadJS(int data);
        }
    */

    /*[-teaVM;-ADD]
        @org.teavm.jso.JSFunctor
        public interface OnSave extends org.teavm.jso.JSObject {
            boolean onSaveJS(int data, int reason);
        }
    */

    /*[-teaVM;-REPLACE]
        public LoadSaveSettingsListener() {
            OnLoad onLoad = new OnLoad() {
                @Override
                public void onLoadJS (int data) {
                    onLoad(data);
                }
            };
            OnSave onSave = new OnSave() {
                @Override
                public boolean onSaveJS (int data, int reason) {
                    return onSaveInternal(data, reason);
                }
            };
            int pointer = createNative(onLoad, onSave);
            initObject(pointer, true);
        }
    */
    public LoadSaveSettingsListener() {
        long addr = createNATIVE();
        initObject(addr, true);
    }

    /*[-C++;-NATIVE]
        if(loadSaveSettingsListenerClass == 0) {
            loadSaveSettingsListenerClass = (jclass)env->NewGlobalRef(env->GetObjectClass(object));
            onLoadID = env->GetMethodID(loadSaveSettingsListenerClass, "onLoad", "(J)V");
            onSaveID = env->GetMethodID(loadSaveSettingsListenerClass, "onSaveInternal", "(JI)Z");
        }
        return (jlong)new LoadSaveSettingsListenerImpl(env, env->NewGlobalRef(object));
    */
    /*[-teaVM;-REPLACE]
        @org.teavm.jso.JSBody(params = { "onLoad", "onSave" }, script = "var jsListener = new [MODULE].LoadSaveSettingsListenerImpl(); jsListener.onLoad = onLoad; jsListener.onSave = onSave; return [MODULE].getPointer(jsListener);")
        private static native int createNative(OnLoad onLoad, OnSave onSave);
    */
    private native long createNATIVE();

    private void onLoad(long data) {
        IDLString tmp = IDLString.TMP_EMPTY_1;
        tmp.setPointer(data);
        onLoad(tmp);
    }

    private boolean onSaveInternal(long data, int reason) {
        IDLString tmp = IDLString.TMP_EMPTY_1;
        tmp.setPointer(data);
        return onSave(tmp, reason);
    }

    public abstract void onLoad(IDLString data);
    public abstract boolean onSave(IDLString data, int reason);
}