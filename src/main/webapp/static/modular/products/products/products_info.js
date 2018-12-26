/**
 * 初始化产品列表详情对话框
 */
var ProductsInfoDlg = {
    productsInfoData : {}
};

/**
 * 清除数据
 */
ProductsInfoDlg.clearData = function() {
    this.productsInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ProductsInfoDlg.set = function(key, val) {
    this.productsInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ProductsInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
ProductsInfoDlg.close = function() {
    parent.layer.close(window.parent.Products.layerIndex);
}

/**
 * 收集数据
 */
ProductsInfoDlg.collectData = function() {
    this
    .set('productTitle')
    .set('productIcon')
    .set('productSlogen')
    .set('productCategory')
    .set('productRate')
    .set('productMaximum')
    .set('productMinimum')
    .set('productUrl')
    .set('hotFlag')
    .set('applyCount')
    .set('checkoutMode')
    .set('bonusMode')
    .set('bonusType')
    .set('bonusValue')
    .set('bonusRate')
    .set('agenShareUrl');
}

/**
 * 提交添加
 */
ProductsInfoDlg.addSubmit = function() {
    this.clearData();
    this.collectData();
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/products/add", function(data){
        Feng.success("添加成功!");
        window.parent.Products.table.refresh();
        ProductsInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.productsInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
ProductsInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/products/update", function(data){
        Feng.success("修改成功!");
        window.parent.Products.table.refresh();
        ProductsInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.productsInfoData);
    ajax.start();
}

$(function() {
});
