    /**
     * 第一个方法获取数据库中的信息，展示在页面
     * 将表单中的内容发送到后台
     * @type {string}
     */
    $(function () {
    var initUrl="/o2o/shopadmin/getshopinitinfo";
    var registerShopUrl="/o2o/shopadmin/registerShop";
    getShopInitInfo();
    function getShopInitInfo() {
        $.getJSON(initUrl,function (data) {
            if(data.success){
                var tempHtml='';
                var tempAreaHtml='';
               data.shopCategoryList.map(function (item, index) {
                    tempHtml+='<option data-id='+item.shopCategoryId+'>'
                 +item.shopCategoryName+'</option>';
                 });
                 data.areaList.map(function (item, index) {
                     tempAreaHtml+='<option data-id="'+item.areaID+'">'
                 +item.areaName+'</option>';
                 });

                $('#shop-categroy').html(tempHtml);
                $('#area').html(tempAreaHtml);
            }
        });
        $("#submit").click(function () {
            var shop={};
            shop.shopName=$("#shop-name").val();
            shop.shopAddr=$("#shop-addr").val();
            shop.phone=$("#shop-phone").val();
            shop.shopDesc=$("#shop-desc").val();
            shop.shopCategroy={
                shopCategoryId:$("#shop-categroy").find('option').not(function () {
                    return !this.selected;
                }).data('id')
            };
            shop.area={
                areaId:$("area").find('option').not(function () {
                    return !this.selected;
                }).data('id')
            };
            var shopImg=$('#shop-img')[0].files[0];
            var formData=new FormData();
            formData.append('shopImg',shopImg);
            formData.append('shopstr',JSON.stringify(shop));
            $.ajax({
                url:registerShopUrl,
                type:'POST',
                data:formData,
                contentType:false,
                proceesData:false,
                cache:false,
                success:function (data) {
                    if(data.success){
                        $.toast('提交成功')
                    }else{
                        $.toast('提交失败'+data.errMsg);
                    }
                }
            })
        })
    }
})