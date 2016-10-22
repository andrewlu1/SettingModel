# SettingModel
实现多进程环境使用的SharePreference操作类。

# 使用方法
通过Settings接口实现类似SharePreference的操作。同时为多进程安全的。
注意：Settings使用前需要进行初始化，一般在Application中进行初始化，或者在Activity创建时调用初始化：

  Settings.init(this);

保存数据时：
  Settings.instance().setXXX(key,value);
  
获取数据：
  Settings.instance().getXXX(key);

新特性：
1. 不需要关注多进程环境问题，它可以保证多进程环境执行的稳定性和鲁棒性。

2. 使用Settings对象可以对每个设置项的变更进行监听，以便设置变化时通知外界进行处理：

  Settings.instance().addOnChangeListener(new OnKeyValueChangeListener(){
    void onChange(String key, Object value){
      Log.d("TAG", "key-value changed :"+key);
    }
  });
  
3. 使用Setting对象还可以设置数据存储的加密过程，这可以通过初始化时设定的加密工厂类类提供支持：
   Settings.inint(this);
   Settings.instance().setSecureFactory(new SecureFactory(){
        //用于存储时加密字符串
        String encode(String k){
          //TODO:实现key/value的加密算法。
        }

        //用于读取时解密字符串
        String decode(String k){
          //TODO:实现对应的解密算法。
        }
   });
   
   系统已经默认为Settings添加了AES加密存储方案，这会保证存入数据库的内容无法破解，无法识别。
   但你也可以主动关闭加密存储，只需要简单的调用：
   Settings.instance().setDebugable(true);
   这样存入数据库的内容皆为可见字符串，便于调试等操作，但不够安全。
   
   

