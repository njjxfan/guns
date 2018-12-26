/**
 * 产品列表管理初始化
 */
var Products = {
    id: "ProductsTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Products.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '产品ID', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '产品名称', field: 'productTitle', visible: true, align: 'center', valign: 'middle'},
            {title: '产品图标', field: 'productIcon', visible: true, align: 'center', valign: 'middle'},
            {title: '产品广告语', field: 'productSlogen', visible: true, align: 'center', valign: 'middle'},
            {title: '产品种类', field: 'productCategory', visible: true, align: 'center', valign: 'middle'},
            {title: '产品利率', field: 'productRate', visible: true, align: 'center', valign: 'middle'},
            {title: '最高额度', field: 'productMaximum', visible: true, align: 'center', valign: 'middle'},
            {title: '最低可贷', field: 'productMinimum', visible: true, align: 'center', valign: 'middle'},
            {title: '产品网址', field: 'productUrl', visible: true, align: 'center', valign: 'middle'},
            {title: '热门falg', field: 'hotFlag', visible: true, align: 'center', valign: 'middle'},
            {title: '申请人数', field: 'applyCount', visible: true, align: 'center', valign: 'middle'},
            {title: '结算模式', field: 'checkoutMode', visible: true, align: 'center', valign: 'middle'},
            {title: '返佣模式', field: 'bonusMode', visible: true, align: 'center', valign: 'middle'},
            {title: '计佣形式', field: 'bonusType', visible: true, align: 'center', valign: 'middle'},
            {title: '返佣金额', field: 'bonusValue', visible: true, align: 'center', valign: 'middle'},
            {title: '返佣比例', field: 'bonusRate', visible: true, align: 'center', valign: 'middle'},
            {title: '分享页面网址', field: 'agenShareUrl', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Products.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Products.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加产品列表
 */
Products.openAddProducts = function () {
    var index = layer.open({
        type: 2,
        title: '添加产品列表',
        area: ['900px', '520px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/products/products_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看产品列表详情
 */
Products.openProductsDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '产品列表详情',
            area: ['900px', '520px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/products/products_update/' + Products.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除产品列表
 */
Products.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/products/delete", function (data) {
            Feng.success("删除成功!");
            Products.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("productsId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询产品列表列表
 */
Products.search = function () {
    var queryData = {};
    queryData['productTitle'] = $("#productTitle").val();
    Products.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Products.initColumn();
    var table = new BSTable(Products.id, "/products/list", defaultColunms);
    table.setPaginationType("client");
    Products.table = table.init();
});
