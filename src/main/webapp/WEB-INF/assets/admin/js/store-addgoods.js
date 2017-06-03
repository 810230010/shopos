/**
 * Created by nilme on 2017/4/19.
 */
var category1, category2, category3;//分类定义

$("#wizard").steps({
    bodyTag: "fieldset",
    labels: {
        cancel: "取消",
        current: "current step:",
        pagination: "Pagination",
        finish: "提交",
        next: "下一步",
        previous: "上一步",
        loading: "加载中 ..."
    },
    onStepChanging: function (event, currentIndex, newIndex) {
        if (currentIndex > newIndex) {
            return true;
        }
        if (currentIndex == 0) {
            if (category1 == null || category1 == "" || category2 == null || category2 == "" || category3 == null || category3 == "") {
                toastr.options = {
                    closeButton: true,
                    progressBar: true,
                    showMethod: 'slideDown',
                    timeOut: 1500
                };
                toastr.error('请选择完整三级分类');
                return false;
            } else {
                return true;
            }
        }
        if (currentIndex == 1) {
            //商品图片集
            var images = "";
            var imgs_dom = $("#goods-images-div .kv-zoom-cache .kv-file-content img");
            var flag = 0;
            imgs_dom.each(function (index, item) {
                if (flag ==0){
                    images += item.src;
                    flag = 1;
                }else{
                    images += "&&" + item.src;
                }
            });
            //商品标题图片
            var logo_dom = $("#goods-logo-div .kv-zoom-cache .kv-file-content img");
            var titleImg = logo_dom.attr("src");
            var form = $(this);
            form.valid();
            if (titleImg==null||titleImg==""||images=="") {
                toastr.options = {
                    closeButton: true,
                    progressBar: true,
                    showMethod: 'slideDown',
                    timeOut: 1500
                };
                toastr.error('请选择商品logo图片和图片集');
                return false;
            } else {
                return true;
            }
        }
        var form = $(this);
        return form.valid();
    },
    onStepChanged: function (event, currentIndex, priorIndex) {
        return true;
    },
    onFinishing: function (event, currentIndex) {
        var form = $(this);

        // Disable validation on fields that are disabled.
        // At this point it's recommended to do an overall check (mean ignoring only disabled fields)
        form.validate().settings.ignore = ":disabled";

        // Start validation; Prevent form submission if false
        return form.valid();
    },
    onFinished: function (event, currentIndex) {
        ////////////////商品图片集//////////////
        var images = "";
        var imgs_dom = $("#goods-images-div .kv-zoom-cache .kv-file-content img");
        var flag = 0;
        imgs_dom.each(function (index, item) {
            if (flag ==0){
                images += item.src;
                flag = 1;
            }else{
                images += "&&" + item.src;
            }
        });
        //////////////商品标题图片//////////////
        var logo_dom = $("#goods-logo-div .kv-zoom-cache .kv-file-content img");
        var titleImg = logo_dom.attr("src");

        ////////////////商品属性//////////////
        var attr_data = [];//属性对象

        var sku_img_name = $("input[id='sku_img_name']").val();
        var sku_img_list = $('[id^=img_value]');
        var sku_img_src_list = $('[id^=img_src]');

        if (sku_img_list.length > 0 && (sku_img_name!=""||sku_img_name!=null)) {
            var obj = {};

            obj.name = sku_img_name;
            obj.isImg = true;

            var imgs = new Array();
            sku_img_list.each(function (index, element) {
                var obj = {};
                obj.name = element.value;
                obj.img = $(sku_img_src_list[index]).attr("src");
                imgs.push(obj);
            });
            obj.values = imgs;
            attr_data.push(obj)
        }

        var list_name = $('[id^=sku_attribute_item_name]');

        list_name.each(function (index, element) {
            if (element.value != null && element.value != "") {
                var obj = {};
                obj.name = $(element).val();
                obj.isImg = false;

                var id = element.id.replace("sku_attribute_item_name", "");
                var values = $("#sku_attribute_item_value" + id).tagsinput('items');

                var name_values = new Array();
                for (var i=0;i<values.length;i++){
                    var v = {};
                    v.name = values[i];
                    name_values.push(v);
                }

                obj.values = name_values;
                attr_data.push(obj);
            }
        });

        ////////////////表格信息//////////
        var table_data = [];
        $('#process').children('tbody').children('tr').each(function(rowIndex, row) {
            var cell = $(row).children();
            var rowlength= $(row).children().length;
            var oj = {};
            var values = "";
            var falg = 0;
            for (var i = 0;i<rowlength-2;i++){
                if (falg==0){
                    values += cell[i].innerHTML;
                    falg=1;
                }else{
                    values += "##"+cell[i].innerHTML;
                }
            }
            oj.skuStock = $($(cell[rowlength-1]).children()).val();
            oj.skuPrice = $($(cell[rowlength-2]).children()).val();
            oj.skuValue =values;
            table_data.push(oj);
        });

        ////////////////提交/////////////
        $.post("/store/goods/add",
            {
                goodsCategory3Id: category3,
                goodsCategory2Id: category2,
                goodsCategory1Id: category1,
                images: images,
                titleImg: titleImg,
                name: $("#name").val(),
                unit: $("#unit").val(),
                price: $("#price").val(),
                marketprice: $("#marketprice").val(),
                commission: $("#commission").val(),
                carriage: $("#carriage").val(),
                adWord: $("#adWord").val(),
                sellTimeBegin: $("#datetimepicker-begin").val(),
                sellTimeEnd: $("#datetimepicker-end").val(),
                name: $("#name").val(),
                type: $("input[name='goods_type']:checked").val(),
                goodsBody: $("#goodsBody").val(),
                skuStr: JSON.stringify(table_data),
                attrs: JSON.stringify(attr_data),
            },
            function (data, status) {
                if (data.code == 200) {
                    swal({
                        title: "成功!",
                        text: "商品添加成功!",
                        type: "success",
                        showConfirmButton: false,
                        timer: 2000,
                    });
                    setTimeout(function () {
                        window.location.href = "/store/goods/addPage";
                    }, 2000);
                }else{
                    swal({
                        title: "请重试!",
                        text: "商品添加失败!",
                        type: "error",
                        showConfirmButton: false,
                        timer: 2000,
                    });
                }
            });
    }
}).validate({
    errorPlacement: function (error, element)
    {
        error.insertAfter(element);
    },
    messages:{
        name: {
            required: "请输入商品名称",
        },
        unit: {
            required: "请输入商品单位",
        },
        price: {
            required: "请输入商品价格",
        },
        commission: {
            required: "请输入商品佣金",
        },
        carriage: {
            required: "请输入商品运费",
        },
        adWord: {
            required: "请输入商品广告词",
        }
    },
    rules: {
        name: {
            required: true,
        },
        unit: {
            required: true,
        },
        price: {
            required: true,
        },
        commission: {
            required: true,
        },
        carriage: {
            required: true,
        },
        adWord: {
            required: true,
        }
    }
});

///////////////////选择商品分类//////////////////////

$(document).ready(function () {
    var categories = [];
    categories = getCategory(0);
    var html = "";
    categories.forEach(function (value, index, array) {
        html += '<li><a onclick="setCategory2(' + value.goodsCategoryId + ')">' + value.name + '<i id="icon1' + value.goodsCategoryId + '" class="gc-icon1 pull-right fa fa-check hidden"></i></a></li>';
    });

    $("#category1").html(html);
    $("#category2").html("");
    $("#category3").html("");
});

function setCategory2(parentId) {
    $(".gc-icon1").addClass("hidden");
    $("#icon1" + parentId).removeClass("hidden");
    $("#icon1" + parentId).addClass("show");

    category1 = parentId;
    category2 = "";
    category3 = "";
    var categories = [];
    categories = getCategory(parentId);

    var html = "";
    categories.forEach(function (value, index, array) {
        html += '<li><a onclick="setCategory3(' + value.goodsCategoryId + ')">' + value.name + '<i id="icon2' + value.goodsCategoryId + '" class="gc-icon2 pull-right fa fa-check hidden"></i></a></li>';
    });
    $("#category2").html(html);
    $("#category3").html("");
}

function setCategory3(parentId) {
    $(".gc-icon2").addClass("hidden");
    $("#icon2" + parentId).removeClass("hidden");
    $("#icon2" + parentId).addClass("show");

    category2 = parentId;
    category3 = "";
    var categories = [];
    categories = getCategory(parentId);

    var html = "";
    categories.forEach(function (value, index, array) {
        html += '<li><a onclick="setCategory4(' + value.goodsCategoryId + ')">' + value.name + '<i id="icon3' + value.goodsCategoryId + '" class="gc-icon3 pull-right fa fa-check hidden"></i></a></li>';
    });
    $("#category3").html(html);
}
function setCategory4(parentId) {
    $(".gc-icon3").addClass("hidden");
    $("#icon3" + parentId).removeClass("hidden");
    $("#icon3" + parentId).addClass("show");
    category3 = parentId;
    console.log(category1 + "---" + category2 + "---" + category3);
}

function getCategory(parentId) {
    var categories = [];
    $.ajax({
        type: "post",
        url: "/store/goodsCategory/get/grade",
        data: "parentId=" + parentId,
        async: false,
        success: function (data) {
            if (data.code == 200) {
                categories = data.data.goodsCategories;
            }
        }
    });
    return categories;
}


///////////////////输入通用属性//////////////////////

$(document).ready(function() {
    $("input[name='goods_type']").change(
        function() {
           var goods_type = $("input[name='goods_type']:checked").val();

            switch(goods_type)
            {
                case 'GOODS_TYPE_ACTIVITY':
                    $(".goods-type-model").addClass("hidden");
                    $("#activity-time").removeClass("hidden");
                    break;
                case 'GOODS_TYPE_SECKILL':
                    $(".goods-type-model").addClass("hidden");
                    $("#activity-time").removeClass("hidden");
                    break;
                case 'GOODS_TYPE_NORMAL':
                    $(".goods-type-model").addClass("hidden");
                    break;
                default:
                    $(".goods-type-model").addClass("hidden");
            }

        });

    $('#datetimepicker-begin').datetimepicker({
        keyboardNavigation: false,
        forceParse: false,
        autoclose: true,
        todayBtn: true,
        language: 'zh-CN',
        format: 'yyyy-mm-dd hh:ii:ss',
    });

    $('#datetimepicker-end').datetimepicker({
        keyboardNavigation: false,
        forceParse: false,
        autoclose: true,
        todayBtn: true,
        language: 'zh-CN',
        format: 'yyyy-mm-dd hh:ii:ss',
    });
});

$('#goods-logo').fileinput({
    language: 'zh',
    uploadUrl: "http://up.qiniu.com",
    uploadExtraData: {
        token: uploadToken
    },
    overwriteInitial: true,
    autoReplace: true,
    showUploadedThumbs: false,
    uploadAsync: true,
//        browseClass: "btn btn-primary", //按钮样式
    msgFilesTooMany: "选择上传的文件数量({1}) 超过允许的最大数值{1}！",
    maxFileCount: 1,
    layoutTemplates: {actionDelete: '',actionZoom:''},
    initialPreviewShowDelete: false,
    showUpload: false, //是否显示上传按钮
    showRemove: false,
    showClose: false,
    initialPreviewAsData: true,
    initialPreview: [],
    initialPreviewConfig: [],
    allowedFileExtensions: ['jpg', 'png', 'gif', 'jpeg'],
}).on("fileuploaded", function (event, data, previewId, index) {
    console.log("自动上传成功index:"+index);
    console.log("fileuploaded-filenames--for"+index+"="+data.filenames[index]);

    var img_dom = $(".kv-file-content img[title='"+data.filenames[index]+"']");

    img_dom.attr('src', domain+data.response.key);
}).on("filebatchselected", function (event, files) {
    $(this).fileinput("upload");
});

$('#goods-images').fileinput({
    language: 'zh',
    uploadUrl: "http://up.qiniu.com",
    uploadExtraData: {
        token: uploadToken
    },
    overwriteInitial: false,
    autoReplace: true,
    showUploadedThumbs: true,
    uploadAsync: true,
//        browseClass: "btn btn-primary", //按钮样式
    msgFilesTooMany: "选择上传的文件数量({1}) 超过允许的最大数值{1}！",
    maxFileCount: 5,
    layoutTemplates: {actionZoom: ''},
    initialPreviewShowDelete: true,
    showUpload: false, //是否显示上传按钮
    showRemove: false,
    showClose: false,
    initialPreviewAsData: true,
    initialPreview: [],
    initialPreviewConfig: [],
    allowedFileExtensions: ['jpg', 'png', 'gif', 'jpeg'],
}).on("fileuploaded", function (event, data, previewId, index) {
    console.log("自动上传成功index:"+index);
    console.log("fileuploaded-filenames--for"+index+"="+data.filenames[index]);

    var img_dom = $(".kv-file-content img[title='"+data.filenames[index]+"']");

    img_dom.attr('src', domain+data.response.key);
}).on("filebatchselected", function (event, files) {
    $(this).fileinput("upload");
});

$(".brand-select").select2({
    ajax: {
        url: "/admin/goodsCategory/get/all",
        dataType: 'json',
        delay: 250,
        data: function (params) {
            return {
                q: params.term, // search term
                page: params.page
            };
        },
        processResults: function (data, params) {
            var results = [];
            $.each(data.data.goodsCategories, function (i, v) {
                var o = {};
                o.id = v.goodsCategoryId;
                o.name = v.name;
                results.push(o);
            })
            return {
                results: results
            };
        },
        cache: true
    },
    formatSelection: function (item) {
        return item.name;
    },  // 选择结果中的显示
    formatResult: function (item) {
        return item.name;
    },  // 搜索列表中的显示
    escapeMarkup: function (markup) {
        return markup;
    }, // let our custom formatter work
    minimumInputLength: 1,
    templateResult: function formatRepo(repo) {
        return repo.name
    },
    templateSelection: function formatRepo(repo) {
        return repo.name
    },
    language: "zh-CN",
});

///////////////////////////////商品详情编辑//////////////////////

// 封装 console.log 函数
function printLog(title, info) {
    window.console && console.log(title, info);
}

// 初始化七牛上传
function uploadInit() {
    // this 即 editor 对象
    var editor = this;
    // 触发选择文件的按钮的id
    var btnId = editor.customUploadBtnId;
    // 触发选择文件的按钮的父容器的id
    var containerId = editor.customUploadContainerId;

    // 创建上传对象
    var uploader = Qiniu.uploader({
        runtimes: 'html5,flash,html4',    //上传模式,依次退化
        browse_button: btnId,       //上传选择的点选按钮，**必需**
        uptoken : uploadToken,
        domain: domain,
        container: containerId,           //上传区域DOM ID，默认是browser_button的父元素，
        max_file_size: '100mb',           //最大文件体积限制
        flash_swf_url: '../js/plupload/Moxie.swf',  //引入flash,相对路径
        filters: {
            mime_types: [
                //只允许上传图片文件 （注意，extensions中，逗号后面不要加空格）
                { title: "图片文件", extensions: "jpg,jpeg,gif,png,bmp" }
            ]
        },
        max_retries: 3,                   //上传失败最大重试次数
        dragdrop: true,                   //开启可拖曳上传
        drop_element: 'editor-container',        //拖曳上传区域元素的ID，拖曳文件或文件夹后可触发上传
        chunk_size: '4mb',                //分块上传时，每片的体积
        auto_start: true,                 //选择文件后自动上传，若关闭需要自己绑定事件触发上传
        init: {
            'FilesAdded': function(up, files) {
                plupload.each(files, function(file) {
                    // 文件添加进队列后,处理相关的事情
                    printLog('on FilesAdded');
                });
            },
            'BeforeUpload': function(up, file) {
                // 每个文件上传前,处理相关的事情
                printLog('on BeforeUpload');
            },
            'UploadProgress': function(up, file) {
                // 显示进度条
                editor.showUploadProgress(file.percent);
            },
            'FileUploaded': function(up, file, info) {
                printLog(info);
                var domain = up.getOption('domain');
                var res = $.parseJSON(info);
                var sourceLink = domain + res.key; //获取上传成功后的文件的Url

                printLog(sourceLink);

                editor.command(null, 'insertHtml', '<img src="' + sourceLink + '" style="max-width:100%;"/>')
            },
            'Error': function(up, err, errTip) {
                printLog('on Error');
            },
            'UploadComplete': function() {
                printLog('on UploadComplete');
                // 隐藏进度条
                editor.hideUploadProgress();
            }
        }
    });
}

var editor = new wangEditor('goodsBody');
editor.config.customUpload = true;  // 设置自定义上传的开关
editor.config.customUploadInit = uploadInit;  // 配置自定义上传初始化事件，uploadInit方法在上面定义了
editor.create();

///////////////////添加属性//////////////////////

var temp = '<div id="sku_attribute_item{id}">' +
    '<div class="form-group">' +
    '<label class="col-sm-1 control-label">其他属性</label>' +
    '<div class="col-sm-2">' +
    '<input id="sku_attribute_item_name{id}" name="name" type="text" class="form-control">' +
    '</div>' +
    '<div class="col-sm-1">' +
    '<div  class="btn btn-primary dim" type="button" onclick="item_remove({id})" ><i class="fa fa-trash"></i></div>' +
    '</div>' +
    '</div>' +
    '<div class="form-group">' +
    '<label class="col-sm-1 control-label">属性值</label>' +
    '<div class="col-sm-11">' +
    '<input type="text" value="" style="width: 300px;" id="sku_attribute_item_value{id}" data-role="tagsinput"/>' +
    '</div>' +
    '</div>' +
    '<div class="hr-line-dashed"></div>' +
    '</div>';

var img_temp = '<div id="img_content{imgid}" class="pull-left" style="height: 145px;width: 120px;margin-right: 10px;">' +
    '<img id="img_src{imgid}" style="height: 120px; width:120px;overflow: hidden">' +
    '<button id="img_content_bt{imgid}" class="btn btn-danger btn-circle" style="position: relative;left: 5px;top: -115px;" type="button" onclick="imag_item_remove({imgid})"><i class="fa fa-times"></i></button>'+
    '<input id="img_value{imgid}" name="img_value_name" style="position: relative;top: -30px;" type="text" class="form-control">' +
    '</div>';

var id = 1;
var imgid = 1;
var step = createStep();
$(document).ready(function () {
    $("#sku_attribute").append(temp.replace(new RegExp('{id}', 'gm'), id));
    $("#sku_attribute_item_value" + id).tagsinput();
    id++;
    reCreateTable();
});

$("#sku-content-add").on('click', function () {
    $("#sku_attribute").append(temp.replace(new RegExp('{id}', 'gm'), id));
    $("#sku_attribute_item_value" + id).tagsinput();
    id++;
});

function item_remove(id) {
    $("#sku_attribute_item" + id).remove();
}

function imag_item_remove(imgid) {
    $("#img_content" + imgid).remove();
}

$("#create_table").on('click', function () {
    reCreateTable();
});


function reCreateTable() {
    var arrayTile = new Array();//标题组数
    var arrayInfor = new Array();//属性数组

    var sku_img_name = $("input[id='sku_img_name']").val();
    var sku_img_list = $('[id^=img_value]');

    if (sku_img_list.length > 0) {
        arrayTile.push(sku_img_name);
        var imgs = new Array();
        sku_img_list.each(function (index, element) {
            imgs.push(element.value);
        });
        arrayInfor.push(imgs);
    }

    var list_name = $('[id^=sku_attribute_item_name]');
    var list_value = $('[id^=sku_attribute_item_value]');

    list_name.each(function (index, element) {
        if (element.value != null && element.value != "") {
            var id = element.id.replace("sku_attribute_item_name", "");
            var values = $("#sku_attribute_item_value" + id).tagsinput('items');
            if (values.length > 0) {
                arrayTile.push(element.value);
                arrayInfor.push(values);
            }
        }
    });

    if (arrayTile.length > 0 && arrayInfor.length > 0) {
        step.Creat_Table(arrayTile, arrayInfor);
    }
}

var uploader = WebUploader.create({
    // 选完文件后，是否自动上传。
    auto: true,
    // swf文件路径
    swf: '/assets/admin/js/plugins/webuploader/Uploader.swf',
    // 文件接收服务端。
    server: 'http://up.qiniu.com',
    // 选择文件的按钮。可选。
    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
    pick: '#sku_img_picker',
    formData: {
        token: uploadToken
    },
    // 只允许选择图片文件。
    accept: {
        title: 'Images',
        extensions: 'gif,jpg,jpeg,bmp,png',
        mimeTypes: 'image/*'
    }
});

// 当有文件添加进来的时候
uploader.on('fileQueued', function (file) {
    var list = $("#sku_img_list");
    list.append(img_temp.replace(new RegExp('{imgid}', 'gm'), imgid));
    // 创建缩略图
    uploader.makeThumb(file, function (error, src) {
        if (error) {
            img.replaceWith('<span>不能预览</span>');
            return;
        }
        $("#img_src" + imgid).attr('src', src);
    }, 0.7, 0.7);
});

// 文件上传过程中创建进度条实时显示。
uploader.on('uploadProgress', function (file, percentage) {
    var li = $('#' + file.id), percent = li.find('.progress span');
    // 避免重复创建
    if (!percent.length) {
        percent = $('<p class="progress"><span></span></p>').appendTo(li).find('span');
    }
    percent.css('width', percentage * 100 + '%');
});

// 文件上传成功，给item添加成功class, 用样式标记上传成功。
uploader.on('uploadSuccess', function (file, response) {
    $("#img_src" + imgid).attr('src', domain+response.key);
    imgid++
    console.log(response);
});

// 文件上传失败，显示上传出错。
uploader.on('uploadError', function (file) {
    var li = $('#' + file.id), error = li.find('div.error');
    // 避免重复创建
    if (!error.length) {
        error = $('<div class="error"></div>').appendTo(li);
    }
    error.text('上传失败');
});

// 完成上传完了，成功或者失败，先删除进度条。
uploader.on('uploadComplete', function (file) {
    $('#' + file.id).find('.progress').remove();
});


///////////////////提交//////////////////////

