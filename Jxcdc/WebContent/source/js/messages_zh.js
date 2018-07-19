(function( factory ) {
	if ( typeof define === "function" && define.amd ) {
		define( ["jquery", "../jquery.validate"], factory );
	} else if (typeof module === "object" && module.exports) {
		module.exports = factory( require( "jquery" ) );
	} else {
		factory( jQuery );
	}
}

(function( $ ) {

/*
 * Translated default messages for the jQuery validation plugin.
 * Locale: ZH (Chinese, 中文 (Zhōngwén), 汉语, 漢語)
 */
jQuery.extend(jQuery.validator.messages, {  
	required: "必填",
	remote: "请修正该字段",
	email: "请输入正确格式的电子邮件",
	url: "请输入合法的网址",
	date: "请输入合法的日期",
	dateISO: "请输入合法的日期 (ISO).",
	number: "请输入合法的数字",
	digits: "只能输入整数",
	creditcard: "请输入合法的信用卡号",
	equalTo: "请再次输入相同的值",
	accept: "请输入拥有合法后缀名的字符串",
	maxlength: jQuery.validator.format("请输入 长度少于{0}的字符串"),
	minlength: jQuery.validator.format("请输入长度多余 {0}的字符串"),
	rangelength: jQuery.validator.format("请输入 长度 {0}和 {1}的字符串"),
	range: jQuery.validator.format(" 请输入{0}~ {1}的值"),
	max: jQuery.validator.format("请输入小于{0}的值"),
	min: jQuery.validator.format("请输入大于{0}的值")
});
return $;
})

);