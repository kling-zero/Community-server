### 树形组件

组件分两部分，实际使用只导入`ZOTree.vue`文件即可

```js
import Tree from './ZOTree.vue'
```



````html
<Tree 
      :value="TreeData"
      :option="{
               		children: 'next',
               		label: 'title'
               }"
      @change="select"
      />

````

两个对象参数

> option 	设置参数，有以下选项
>
> > children	如果传入数据的子项字段名不为children，则使用该属性指定对应的字段名
> >
> > parent	指定父类节点的图标
> >
> > child		指定非父节点的图标
> >
> > label		如果传入数据的显示数据的字段名不为label，用该属性指定对应的字段名
> >
> > id			如果传入数据的标识属性不为id，则用该属性指定
>
>  
>
> value	数据传入，该数据要求必须为数组

事件

>@select	选中事件，当点击可选项时，触发该事件		接收一个对象参数
>
>@change	只有选中项发生改变时才会触发					接收两个参数，第一个是新选中对象，第二个是之前的选中对象

**本组件有对`ElementUI`系列有一定依赖**

> 依赖为动画，过渡效果，可以无视
