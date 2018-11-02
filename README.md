# WaterView使用方法

项目中引用控件,在根项目build.gradle中添加如下代码

	maven {
		url 'https://dl.bintray.com/wodx521/maven' 
	}

添加完成后如下

	allprojects {
	    repositories {
	        google()
	        jcenter()
	        maven {
				url 'https://dl.bintray.com/wodx521/maven' 
			}
	    }
	}

然后在自己项目中添加引用代码,并同步项目

    implementation 'com.wanou.library:waterview:1.0.0'
	
同步完成后可以在xml中引用WaterView,就可以正常使用了

	<com.wanou.waterview.widget.WaterView
	    android:id="@+id/water_view"
	    android:layout_width="match_parent"
	    android:layout_height="400dp"
	    android:background="@color/colorPrimary" />

生成测试数据
	
	WaterView mWaterView = findViewById(R.id.water_view);

    private List<Water> waterList = new ArrayList<>();

	for (int i = 0; i < 10; i++) {
       waterList.add(new Water(i + 5 + "", "测试"));
    }


其中集合中存储Water对象,对象成员变量number和name,其中number为水滴view下显示的文本显示,生成数据后,通过
	
	mWaterView.setWaters(waterList);

设置数据,视图中的点击事件通过setClickListener调用

	mWaterView.setClickListener(new WaterView.ClickListener() {
        @Override
        public void onViewClickListener(View view, int finalI) {
            view.setClickable(false);
            mWaterView.animRemoveView(view);
        }
    });

设置点击事件后,点击子view后,执行消失动画,并移出WaterView,这样简单实用就完成了

![](https://i.imgur.com/ldTrIJh.gif)

> 默认的子view执行的动画为缩放模式,默认子view的消失位置位于右下角,动画运动差值器LinearInterpolator

#### WaterView属性 ####

![](https://i.imgur.com/NmTHbd1.png)

属性可以设置在xml文件中,也可在代码中进行设置,需要声明app名空间

![](https://i.imgur.com/WIxzEiZ.png)

代码中设置样式,设置样式的方法需要在设置数据前调用,否则只有在下次设置数据后才会生效

	mWaterView.setLayoutStyle(WaterView.CIRCLE_RANDOM);
	mWaterView.setWaters(waterList);

其他属性都有对应的代码设置方法,设置图片属性,设置子View的动画效果属性都需要在设置数据前设置,设置移出子View消失点位置,需要在设置点击时间前设置消失点,默认布局样式为矩形随机布局,默认动画属性为缩放,默认移出点位置为右下角位置

属性text_color设置子View的文本颜色,默认颜色白色

属性text_size设置子View的文本大小,默认大小18

属性drawable_position设置图片为子View背景或为子View顶部图片