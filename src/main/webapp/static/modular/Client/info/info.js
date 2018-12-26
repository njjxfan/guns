/**
 * 用户信息管理初始化
 */
var Info = {
    id: "InfoTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Info.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '昵称', field: 'userName', visible: true, align: 'center', valign: 'middle'},
            {title: '真实姓名', field: 'realName', visible: true, align: 'center', valign: 'middle'},
            {title: '角色', field: 'role', visible: true, align: 'center', valign: 'middle'},
            {title: '手机号', field: 'mobile', visible: true, align: 'center', valign: 'middle'},
            {title: '密码', field: 'password', visible: true, align: 'center', valign: 'middle'},
            {title: '用户头像', field: 'avatar', visible: true, align: 'center', valign: 'middle'},
            {title: '注册时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
            {title: '身份证号', field: 'IdCard', visible: true, align: 'center', valign: 'middle'},
            {title: '可否登录状态', field: 'status', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Info.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Info.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加用户信息
 */
Info.openAddInfo = function () {
    var index = layer.open({
        type: 2,
        title: '添加用户信息',
        area: ['900px', '520px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/info/info_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看用户信息详情
 */
Info.openInfoDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '用户信息详情',
            area: ['900px', '520px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/info/info_update/' + Info.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除用户信息
 */
Info.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/info/delete", function (data) {
            Feng.success("删除成功!");
            Info.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("infoId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询用户信息列表
 */
Info.search = function () {
    var queryData = {};
    queryData['realName'] = $("#realName").val();
    Info.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Info.initColumn();
    var table = new BSTable(Info.id, "/info/list", defaultColunms);
    table.setPaginationType("client");
    Info.table = table.init();
});
