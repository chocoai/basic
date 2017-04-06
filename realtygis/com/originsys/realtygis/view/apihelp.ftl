<link type="text/css" rel="stylesheet" href="${_share_file_url!''}/gis/resource/css/apihelp.css" />
<div class="mbody">
    <div class="mbread clearfix">
        <a href="#">API在线帮助</a>
    </div>
    <div class="mwrapper clearfix">
        <div class="mcontainer" style="width:930px;">
            <h1>API 在线帮助</h1>
            <p style="color:red;"></p>
            <p>房产GIS API接口，是一套基于超图API二次开发的开源的代码库。目前提供多个lib库，帮助开发者快速实现在地图上测距、测面、进行周边查询、按名称查询小区、查询全部小区、在可见视野内查询、拉框查询、对全济南市房屋建筑进行统计并制作专题图、分区统计并制作专题图、可见视野范围统计并制作专题图、自定义范围专题图制作等功能。</p>
            <p>房产GIS API接口只要支持房产工作中的各种流程。您可以参考开发文档，直接调用现有的开源库，实现您的需求。源文件里具有详尽的注释，可以帮助您更好的理解。</p>
            <p>如果您对房产GIS API接口的意见和建议，请即使反馈给我们。</a></p>
            <p>此外，欢迎广大的开发爱好者，提供你们制作的JavaScript library库。我们也会放在这里供其他爱好者学习、交流。</p>
            <p>&nbsp;</p>
            <h2>初始化地图API</h2>
            <div class="lib_box clearfix">
                <img class="lib_img" src="${_share_file_url!''}/gis/FMapLib/theme/images/map.png" width="174" height="130"/>
                <div class="lib_content">
                    <p>根据指定的DIV实例化地图，并在窗口中进行展示。此外还包括地图的清除功能，清除地图上的覆盖物并停止画点线面的功能。 主入口类是FMap， 基于FMapLib-1.0.3。</p>
                    <table>
                        <tr>
                            <td class="t-r"><lable>示例：</lable></td>
                            <td><a target="_blank" href="${_share_file_url!''}/gis/apiexample/map.html">地图初始化示例 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a></td>
                        </tr>
                        <tr>
                            <td class="t-r">类参考：</td>
                            <td><a target="_blank" href="${_share_file_url!''}/gis/apiexample/mapclassreference.html">查看类参考 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a></td>
                        </tr>
                    </table>
                </div>
            </div> 
            <h2>测距功能API</h2>
            <div class="lib_box clearfix">
                <img class="lib_img" src="${_share_file_url!''}/gis/FMapLib/theme/images/cj.png" width="174" height="130"/>
                <div class="lib_content">
                    <p>在地图上任意画一条线段，能够计算线段的长度并在地图窗口的上方显示，主要用于距离的测量和计算。基于FMApLib API v1。0.3。</p>
                    <table>
                        <tr>
                            <td class="t-r"><lable>示例：</lable></td>
                            <td><a target="_blank" href="${_share_file_url!''}/gis/apiexample/distancemeasure.html">测距功能示例 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a></td>
                        </tr>
                        <tr>
                            <td class="t-r">类参考：</td>
                            <td><a target="_blank" href="${_share_file_url!''}/gis/apiexample/cjclassreference.html">查看类参考 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a></td>
                        </tr>
                    </table>
                </div>
            </div> 
			<h2>测面功能API</h2>
            <div class="lib_box clearfix">
                <img class="lib_img" src="${_share_file_url!''}/gis/FMapLib/theme/images/cm.png" width="174" height="130"/>
                <div class="lib_content">
                    <p>在地图上任意画一个多边形，能够计算多边形的面积并在地图窗口的上方显示，主要用于面积的测量和计算。基于FMApLib API v1。0.3。</p>
                    <table>
                        <tr>
                            <td class="t-r"><lable>示例：</lable></td>
                            <td><a target="_blank" href="${_share_file_url!''}/gis/apiexample/measurepolygon.html">测面功能示例 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a></td>
                        </tr>
                        <tr>
                            <td class="t-r">类参考：</td>
                            <td><a target="_blank" href="${_share_file_url!''}/gis/apiexample/cmclassreference.html">查看类参考 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a></td>
                        </tr>
                    </table>
                </div>
            </div>         
			<h2>周边查询API</h2>
            <div class="lib_box clearfix">
                <img class="lib_img" src="${_share_file_url!''}/gis/FMapLib/theme/images/qs.png" width="174" height="130"/>
                <div class="lib_content">
                    <p>周边查询功能类，通过查询的位置和距离确定查询的范围，查找在该范围内的房屋，统计房屋的数量和信息，并以marker的形式在地图上展现。基于FMapLib API 1.0.3.</p>
                    <table>
                        <tr>
                            <td class="t-r"><lable>示例：</lable></td>
                            <td><a target="_blank" href="${_share_file_url!''}/gis/apiexample/querysurrounding.html">周边查询功能示例 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a></td>
                        </tr>
                        <tr>
                            <td class="t-r">类参考：</td>
                            <td><a target="_blank" href="${_share_file_url!''}/gis/apiexample/qsclassreference.html">查看类参考 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a></td>
                        </tr>
                    </table>
                </div>
            </div>             
			<h2>鼠标滑轮监听器API</h2>
            <div class="lib_box clearfix">
                <img class="lib_img" src="${_share_file_url!''}/gis/FMapLib/theme/images/map.png" width="174" height="130" />
                <div class="lib_content">
                    <p>实现鼠标在地图窗口滚动时地图的放大缩小功能。</p>
                    <table>
                        <tr>
                            <td class="t-r"><lable>示例：</lable></td>
                            <td><a target="_blank" href="${_share_file_url!''}/gis/apiexample/mousewheel.html">鼠标滑轮示例 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a></td>
                        </tr>
                        <tr>
                            <td class="t-r">类参考：</td>
                            <td><a target="_blank" href="${_share_file_url!''}/gis/apiexample/mwclassreference.html">查看类参考 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a></td>
                        </tr>
                    </table>
                </div>
            </div> 
            <h2>房屋按建成年代查询API</h2>
            <div class="lib_box clearfix">
                <img class="lib_img" src="${_share_file_url!''}/gis/FMapLib/theme/images/bq.png" width="174" height="130" />
                <div class="lib_content">
                    <p>房屋按建成年代查询API。实现房屋楼幢面按建成年代在地图上渲染显示的功能，是一项基本的查询功能。基于FMapLIb API 1.0。3.</p>
                    <table>
                        <tr>
                            <td class="t-r"><lable>示例：</lable></td>
                            <td><a target="_blank" href="${_share_file_url!''}/gis/apiexample/buildingquerybydate.html">房屋按建成年代查询示例 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a></td>
                        </tr>
                        <tr>
                            <td class="t-r">类参考：</td>
                            <td><a target="_blank" href="${_share_file_url!''}/gis/apiexample/bqclassreference.html">查看类参考 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a></td>
                        </tr>
                    </table>
                </div>
            </div> 
            <h2>项目测绘建筑查询API</h2>
            <div class="lib_box clearfix">
                <img class="lib_img" src="${_share_file_url!''}/gis/FMapLib/theme/images/surveyquery.jpg" width="174" height="130" />
                <div class="lib_content">
                    <p>项目测绘建筑查询API。实现对已有项目测绘数据的房屋楼幢面的查询并在地图窗口中渲染显示，同时获得房屋楼幢面的属性信息。 基于FMapLib API 1.0.3。</p>
                    <table>
                        <tr>
                            <td class="t-r"><lable>示例：</lable></td>
                            <td>
                                <a target="_blank" href="${_share_file_url!''}/gis/apiexample/buildingqueryfromsurvey.html">项目测绘建筑查询示例 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a>
                            </td>
                        </tr>
                        <tr>
                            <td class="t-r">类参考：</td>
                            <td><a target="_blank" href="${_share_file_url!''}/gis/apiexample/surveyqueryreference.html">查看类参考 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a></td>
                        </tr>
                    </table>
                </div>
            </div>
            <h2>房屋按地址模糊查询API</h2>
            <div class="lib_box clearfix">
                <img class="lib_img" src="${_share_file_url!''}/gis/FMapLib/theme/images/BN.png" width="174" height="130" />
                <div class="lib_content">
                    <p>根据输入的字符串查询房屋地址属性信息中包含或等于该字符串的记录，对查询结果进行渲染显示。 基于FMapLib API 1.0.3。
</p>
                    <table>
                        <tr>
                            <td class="t-r"><lable>示例：</lable></td>
                            <td>
                                <a target="_blank" href="${_share_file_url!''}/gis/apiexample/housequerybyname.html">房屋按地址模糊查询示例页面<img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a>                                
                            </td>
                        </tr>
                        <tr>
                            <td class="t-r">类参考：</td>
                            <td><a target="_blank" href="${_share_file_url!''}/gis/apiexample/hnclassreference.html">查看类参考 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a></td>
                        </tr>
                    </table>
                </div>
            </div>
            <h2>地图打印API</h2>
            <div class="lib_box clearfix">
                <img class="lib_img" src="${_share_file_url!''}/gis/FMapLib/theme/images/PM.png" width="174" height="130" />
                <div class="lib_content">
                    <p>实现地图打印功能。 基于FMapLib API 1.0.3.
</p>
                    <table>
                        <tr>
                            <td class="t-r"><lable>示例：</lable></td>
                            <td><a target="_blank" href="${_share_file_url!''}/gis/apiexample/printmap.html">地图打印功能示例 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a></td>
                        </tr>
                        <tr>
                            <td class="t-r">类参考：</td>
                            <td><a target="_blank" href="${_share_file_url!''}/gis/apiexample/pmclassreference.html">查看类参考 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a></td>
                        </tr>
                    </table>
                </div>
            </div> 
            <h2>综合查询API</h2>
            <div class="lib_box clearfix">
                <img class="lib_img" src="${_share_file_url!''}/gis/FMapLib/theme/images/zhcx.jpg" width="174" height="130" />
                <div class="lib_content">
                    <p>综合查询API实现房产数据基本的查询功能，允许用户按自己的要求展现需要的数据，可以扩展地图的使用。 基于FMapLib API 1.0.3。
</p>
                    <table>
                        <tr>
                            <td class="t-r"><lable>示例：</lable></td>
                            <td>
                                <a target="_blank" href="${_share_file_url!''}/gis/apiexample/buildingmiltyquery.html">综合查询使用示例 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a>
                            </td>
                        </tr>
                        <tr>
                            <td class="t-r">类参考：</td>
                            <td><a target="_blank" href="${_share_file_url!''}/gis/apiexample/bmqclassreference.html">查看类参考 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a></td>
                        </tr>
                    </table>
                </div>
            </div>

            <h2>渲染功能API</h2>
            <div class="lib_box clearfix">
                <img class="lib_img" src="${_share_file_url!''}/gis/FMapLib/theme/images/render.png" width="174" height="130" />
                <div class="lib_content">
                    <p>设置地图风格，实现图层渲染功能。 基于FMapLib 1.0.3。
</p>
                    <table>
                        <tr>
                            <td class="t-r">示例：</td>
                            <td>
                                <a target="_blank" href="${_share_file_url!''}/gis/apiexample/buildingmiltyquery.html">渲染功能使用示例 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a>
                            </td>
                        </tr>
                        <tr>
                            <td class="t-r">类参考：</td>
                            <td><a target="_blank" href="${_share_file_url!''}/gis/apiexample/renderclassreference.html">查看类参考 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a></td>
                        </tr>
                    </table>
                </div>
            </div> 
            <h2>工具条API</h2>
            <div class="lib_box clearfix">
                <img class="lib_img" src="${_share_file_url!''}/gis/FMapLib/theme/images/toolbar.png" width="174" height="130" />
                <div class="lib_content">
                    <p>添加工具条API实现工具条的添加功能，工具条包括：清除、前进、后退、测距、测面、打印等功能，属于地图的基本操作。 基于FMapLib API 1.0。3.</p>
                    <table>
                        <tr>
                            <td class="t-r"><lable>示例：</lable></td>
                            <td>
                                <a target="_blank" href="${_share_file_url!''}/gis/apiexample/toolbar.html">工具条示例 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a>
                            </td>                            
                        </tr>
                        <tr>
                            <td class="t-r">类参考：</td>
                            <td><a target="_blank" href="${_share_file_url!''}/gis/apiexample/tbclassreference.html">查看类参考 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a></td>
                        </tr>
                    </table>
                </div>
            </div>
            <h2>地图影像切换器API</h2>
            <div class="lib_box clearfix">
                <img class="lib_img" src="${_share_file_url!''}/gis/FMapLib/theme/images/switch.png" width="174" height="130" />
                <div class="lib_content">
                    <p>添加地图影像切换器类主要实现了矢量地图和影像图的切换功能，属于地图交互的基本操作。 基于FMapLib API 1.0。3.
</p>
                    <table>
                        <tr>
                            <td class="t-r"><lable>示例：</lable></td>
                            <td><a target="_blank" href="${_share_file_url!''}/gis/apiexample/SatelliteMapSwitcher.html">地图影像切换器示例 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a></td>
                        </tr>
                        <tr>
                        <tr>
                            <td class="t-r">类参考：</td>
                            <td><a target="_blank" href="${_share_file_url!''}/gis/apiexample/smclassreference.html">查看类参考 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a></td>
                        </tr>
                    </table>
                </div>
            </div> 
            <h2>全市楼房专题图API</h2>
            <div class="lib_box clearfix">
                <img class="lib_img" src="static/img/MarkerClusterer.png" width="174" height="130" />
                <div class="lib_content">
                    <p>MarkerClusterer标记聚合器用来解决加载大量点要素到地图上产生覆盖现象的问题，并提高性能。 主入口类是MarkerClusterer， 基于Baidu Map API 1.2。
</p>
                    <table>
                        <tr>
                            <td class="t-r"><lable>示例：</lable></td>
                            <td><a target="_blank" href="http://api.map.baidu.com/library/MarkerClusterer/1.2/examples/simple.htm">marker聚合示例 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a></td>
                        </tr>
                        <tr>
                            <td class="t-r">类参考：</td>
                            <td><a target="_blank" href="http://api.map.baidu.com/library/MarkerClusterer/1.2/docs/help.html">查看类参考 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a></td>
                        </tr>
                    </table>
                </div>
            </div>

            <h2>分区统计专题图（柱状图）API</h2>
            <div class="lib_box clearfix">
                <img class="lib_img" src="static/img/MarkerTool.png" width="174" height="130" />
                <div class="lib_content">
                    <p>百度地图的添加标注工具类，对外开放。 允许用户在地图上点击后添加一个点标注，允许用户设定标注的图标样式。 主入口类是MarkerTool， 基于Baidu Map API 1.2。
</p>
                    <table>
                        <tr>
                            <td class="t-r"><lable>示例：</lable></td>
                            <td>
                                <a target="_blank" href="http://api.map.baidu.com/library/MarkerTool/1.2/examples/simple.html">普通可连续添加标注示例 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a>
                                <span>&nbsp;</span>
                                <a target="_blank" href="http://api.map.baidu.com/library/MarkerTool/1.2/examples/advance.html">自定义样式和属性的标注示例 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a>
                            </td>
                        </tr>
                        <tr>
                            <td class="t-r">类参考：</td>
                            <td><a target="_blank" href="http://api.map.baidu.com/library/MarkerTool/1.2/docs/help.html">查看类参考 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a></td>
                        </tr>
                    </table>
                </div>
            </div> 
            <h2>分区统计专题图（饼状图）API</h2>
            <div class="lib_box clearfix">
                <img class="lib_img" src="static/img/myMarker.png" width="174" height="130" />
                <div class="lib_content">
                    <p>此类表示地图上的一个覆盖物，该覆盖物由文字和图标组成，从Overlay继承。 主入口类是TextIconOverlay， 基于Baidu Map API 1.2。
</p>
                    <table>
                        <tr>
                            <td class="t-r"><lable>示例：</lable></td>
                            <td>
                                <a target="_blank" href="http://api.map.baidu.com/library/TextIconOverlay/1.2/examples/simple.htm">查看自定义覆盖物示例 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a>
                                <span>&nbsp;</span>
                                <a target="_blank" href="http://api.map.baidu.com/library/TextIconOverlay/1.2/examples/advanced.htm">修改自定义覆盖物样式示例 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a>
                            </td>
                        </tr>
                        <tr>
                            <td class="t-r">类参考：</td>
                            <td><a target="_blank" href="http://api.map.baidu.com/library/TextIconOverlay/1.2/docs/help.html">查看类参考 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a></td>
                        </tr>
                    </table>
                </div>
            </div>

            <h2>可见视野范围专题图API</h2>
            <div class="lib_box clearfix">
                <img class="lib_img" src="static/img/zoom.png"  width="174" height="130" />
                <div class="lib_content">
                    <p>百度地图的拉框缩放类，对外开放。 允许用户在地图上执行拉框放大或者缩小操作， 使用者可以自定义缩放时的动画、遮盖层的样式等效果。 主入口类是RectangleZoom， 基于Baidu Map API 1.2。
</p>
                    <table>
                        <tr>
                            <td class="t-r"><lable>示例：</lable></td>
                            <td><a target="_blank" href="http://api.map.baidu.com/library/RectangleZoom/1.2/examples/RectangleZoom.html">拉框缩放示例 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a></td>
                        </tr>
                        <tr>
                        <tr>
                            <td class="t-r">类参考：</td>
                            <td><a target="_blank" href="http://api.map.baidu.com/library/RectangleZoom/1.2/docs/help.html">查看类参考 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a></td>
                        </tr>
                    </table>
                </div>
            </div> 
            <h2>自定义范围统计专题图API</h2>
            <div class="lib_box clearfix">
                <img class="lib_img" src="static/img/SearchInRectangle.png"  width="174" height="130" />
                <div class="lib_content">
                    <p>拉框缩放类，实现拉框缩放效果的入口。 主入口类是SearchInRectangle， 基于Baidu Map API 1.2。
</p>
                    <table>
                        <tr>
                            <td class="t-r"><lable>示例：</lable></td>
                            <td>
                                <a target="_blank" href="http://api.map.baidu.com/library/SearchInRectangle/1.2/example/searchInRectangle.html">普通的拉框搜索 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a>
                                <span>&nbsp;</span>
                                <a target="_blank" href="http://api.map.baidu.com/library/SearchInRectangle/1.2/example/searchInRectangle_panel.html">拉框搜索完成后，显示panel面板 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a>
                                <span>&nbsp;</span>
                                <a target="_blank" href="http://api.map.baidu.com/library/SearchInRectangle/1.2/example/searchInRectangle_searchComplete.html">拉框搜索完成后，自定义搜索完成后的样式 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a>
                            </td>
                        </tr>
                        <tr>
                        <tr>
                            <td class="t-r">类参考：</td>
                            <td><a target="_blank" href="http://api.map.baidu.com/library/SearchInRectangle/1.2/doc/help.html">查看类参考 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a></td>
                        </tr>
                    </table>
                </div>
            </div>

            <h2>区域限制</h2>
            <div class="lib_box clearfix">
                <img class="lib_img" src="static/img/cage.png" width="174" height="130" />
                <div class="lib_content">
                    <p>百度地图浏览区域限制类，对外开放。 允许开发者输入限定浏览的地图区域的Bounds值， 则地图浏览者只能在限定区域内浏览地图。 基于Baidu Map API 1.2。
</p>
                    <table>
                        <tr>
                            <td class="t-r"><lable>示例：</lable></td>
                            <td><a target="_blank" href="http://api.map.baidu.com/library/AreaRestriction/1.2/examples/AreaRestriction.html">区域限制示例 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a></td>
                        </tr>
                        <tr>
                        <tr>
                            <td class="t-r">类参考：</td>
                            <td><a target="_blank" href="http://api.map.baidu.com/library/AreaRestriction/1.2/docs/help.html">查看类参考 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a></td>
                        </tr>
                    </table>
                </div>
            </div> 
            <h2>几何运算</h2>
            <div class="lib_box clearfix">
                <img class="lib_img" src="static/img/GeoUtils.png" width="174" height="130" />
                <div class="lib_content">
                    <p>GeoUtils类提供若干几何算法，用来帮助用户判断点与矩形、 圆形、多边形线、多边形面的关系,并提供计算折线长度和多边形的面积的公式。 主入口类是GeoUtils， 基于Baidu Map API 1.2。
</p>
                    <table>
                        <tr>
                            <td class="t-r"><lable>示例：</lable></td>
                            <td><a target="_blank" href="http://api.map.baidu.com/library/GeoUtils/1.2/examples/simple.html">几何计算示例 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a></td>
                        </tr>
                        <tr>
                        <tr>
                            <td class="t-r">类参考：</td>
                            <td><a target="_blank" href="http://api.map.baidu.com/library/GeoUtils/1.2/docs/help.html">查看类参考 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a></td>
                        </tr>
                    </table>
                </div>
            </div>

            <h2>交通流量</h2>
            <div class="lib_box clearfix">
                <img class="lib_img" src="static/img/traffic.png" width="174" height="130" />
                <div class="lib_content">
                    <p>百度地图的交通流量控件，对外开放。 控制当前，未来交通流量图层在地图上的显示，隐藏 等。 主入口类是TrafficControl， PC端基于Baidu Map API 1.2。移动端基于Baidu Map API 1.4，提供高清底图。</p>
                    <table>
                        <tr>
                            <td class="t-r"><lable>示例：</lable></td>
                            <td>交通流量图层：<a target="_blank" href="http://api.map.baidu.com/library/TrafficControl/1.2/examples/trafficControl.html">1.2 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a> <a target="_blank" href="http://api.map.baidu.com/library/TrafficControl/1.4/examples/trafficControl.html">1.4 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a></td>
                        </tr>
                        <tr>
                            <td class="t-r">类参考：</td>
                            <td><a target="_blank" href="http://api.map.baidu.com/library/TrafficControl/1.2/docs/help.html">查看类参考 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a></td>
                        </tr>
                    </table>
                </div>
            </div> 
			
			<h2 id ="SearchControlId">检索控件</h2>
            <div class="lib_box clearfix">
                <img class="lib_img" src="static/img/SearchControl.jpg"  width="174" height="130" />
                <div class="lib_content">
                    <p>SearchControl类，此类提供城市列表选择、本地检索、公交驾车查询功能。 主入口类是SearchControl， 基于Baidu Map API 1.4。
</p>
                    <table>
                        <tr>
                            <td class="t-r"><lable>示例：</lable></td>
                            <td><a target="_blank" href="http://api.map.baidu.com/library/SearchControl/1.4/examples/SearchControl.html">检索与公交驾车查询示例 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a></td>
                        </tr>
                        <tr>
                            <td class="t-r">类参考：</td>
                            <td><a target="_blank" href="http://api.map.baidu.com/library/SearchControl/1.4/docs/help.html">查看类参考 <img src="${_share_file_url!''}/gis/FMapLib/theme/images/btn-see.jpg" /></a></td>
                        </tr>
                    </table>
                </div>
            </div>
            
        </div>
    </div>
    <div class="mwrappend clearfix">&nbsp;</div><div class="copyright clearfix"><p>©2014 Baidu<a href="http://www.baidu.com/duty/">使用百度前必读</a><a target="_blank" href="http://www.miibeian.gov.cn">京ICP证030173号</a><img src="http://gimg.baidu.com/img/gs.gif"></p></div></div>
</div>
