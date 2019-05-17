# Day_Login
注册and登录

利用MVP框架所写

M层是请求数据层和网络层

V层是获取Presenter层数据方法视图展示层

P层是绑定和解绑 引用Model层数据

这个登录没有跳转,只有Toast方法

注册成功则Toast"注册成功"

登录成功则Toast"登录成功"

登录失败则Toast"登录失败 , 密码或者手机号错误"

刚刚又添加了一个横向滑动的条目{
同样利用了MVP框架
在主视图中
 //初始化布局管理器
        manager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
 //添加布局管理器
        recycle.setLayoutManager(manager);
设置适配器
//初始化视图
                  inflate = LayoutInflater.from(context).inflate(R.layout.horitem_layout, viewGroup, false);
                  return new HomeHolder(inflate);//返回很重要!!!
 //绑定视图
 //获取总数据
}
