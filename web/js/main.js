/**
 * 
 */

//XMLHttpRequest组件
var xhs;
//区域菜单的值发生改变时调用该方法,并把区域菜单当前的value传递进来
function cascade(id) {


	//当id不大于0时，说明当前选择的是“请选择”这一项，则不做操作
	if (id != -1) {

		//请求字符串,把区域的id作为页面参数传到后台
		var url = "lesson/getLesson?id=" + id;
		//创建XMLHttpRequest组件
		xhs = new XMLHttpRequest();
		//设置回调函数,processReuqest方法的定义在下面
		xhs.onreadystatechange = processReuqest;
		//打开与服务器的地址连接
		xhs.open("post", url, true);
		//发送请求
		xhs.send(null);
	}
}




//processReuqest方法作为回调方法
function processReuqest() {
	if (xhs.readyState == 4) {
		if (xhs.status == 200) {



			//创建新的select节点
			var newSelect = document.createElement("select");
			newSelect.id = "lesson";
			//为新创建的select节点添加onchange事件，以便测试用
			newSelect.onchange = getDetails;
			//为新创建的select节点添加option节点
			var op = document.createElement("option");
			op.value = -1;
			op.innerHTML = "请选择";
			newSelect.appendChild(op);
			//得到完成请求后返回的字串符
			var str = xhs.responseText;

			//根据返回的字符串为新创建的select节点添加option节点
			var arr = str.split(",");
			for (var i = 0; i < arr.length; i++) {
				var child = document.createElement("option");
				var arr1 = arr[i].split("=");
				child.innerHTML = arr1[1];
				child.value = arr1[0];
				newSelect.appendChild(child);
			}

			//用新select节点替换旧的select节点
			var select = document.getElementById("lesson");
			document.getElementById("le_div").replaceChild(newSelect, select);
		}
	}
}

function getDetails() {
	var id = this.value;
	//当id不大于0时，说明当前选择的是“请选择”这一项，则不做操作
	if (id != -1) {

		var lessonSelect = document.getElementById("t_name");
		var index = lessonSelect.selectedIndex;
		var t_id = lessonSelect.options[index].value;
		
		//请求字符串,把区域的id作为页面参数传到后台
		var url = "getLessonDetail?l_id=" + id + "&t_id=" + t_id;
		//创建XMLHttpRequest组件
		xhs = new XMLHttpRequest();
		//设置回调函数,processReuqest方法的定义在下面
		xhs.onreadystatechange = processClass;
		//打开与服务器的地址连接
		xhs.open("post", url, true);
		//发送请求
		xhs.send(null);
	
	}
}

function processClass() {
	
	if (xhs.readyState == 4) {
		if (xhs.status == 200) {
			var newSelect = document.createElement("select");
			newSelect.id = "lessonClass";
			newSelect.onchange = getFree;
			var op = document.createElement("option");
			op.value = -1;
			op.innerHTML = "请选择";
			newSelect.appendChild(op);
			var str = xhs.responseText;

			var arr = str.split("|");
			for (var i = 0; i < arr.length; i++) {
				var child = document.createElement("option");
				var arr1 = arr[i].split("=");
				child.innerHTML = arr1[1];
				child.value = arr1[0];
				newSelect.appendChild(child);
			}

			var select = document.getElementById("lessonClass");

			document.getElementById("cl_div").replaceChild(newSelect, select);
		}
	}

}


function getFree() {
	var id = this.value;
	//当id不大于0时，说明当前选择的是“请选择”这一项，则不做操作
	if (id != -1) {

		//请求字符串,把区域的id作为页面参数传到后台
		var url = "getFree?id=" + id;
		//创建XMLHttpRequest组件
		xhs = new XMLHttpRequest();
		//设置回调函数,processReuqest方法的定义在下面
		xhs.onreadystatechange = processFree;
		//打开与服务器的地址连接
		xhs.open("post", url, true);
		//发送请求
		xhs.send(null);
	}
}

function processFree() {
	create("ft1");
	create("ft2");
}


function create(id) {
	if (xhs.readyState == 4) {
		if (xhs.status == 200) {
			var newSelect = document.createElement("select");
			newSelect.id = id;
			var op = document.createElement("option");
			op.value = -1;
			op.innerHTML = "请选择";
			newSelect.appendChild(op);
			var str = xhs.responseText;

			var arr = str.split("|");
			for (var i = 0; i < arr.length; i++) {
				var child = document.createElement("option");
				var arr1 = arr[i].split("=");
				child.innerHTML = arr1[1];
				child.value = arr1[0];
				newSelect.appendChild(child);
			}

			var select = document.getElementById(id);
			document.getElementById("fr_div").replaceChild(newSelect, select);
		}
	}

}


function submit () {
	
	var lessonSelect = document.getElementById("lessonClass");
	var index = lessonSelect.selectedIndex;
	var c_id = lessonSelect.options[index].value;
	var lessonSelect = document.getElementById("ft1");
	var index = lessonSelect.selectedIndex;
	var f1_id = lessonSelect.options[index].value;
	var lessonSelect = document.getElementById("ft2");
	var index = lessonSelect.selectedIndex;
	var f2_id = lessonSelect.options[index].value;
	
		var url = "save?c_id="+ c_id+"&f1_id="+f1_id+"&f2_id="+f2_id;
		xhs = new XMLHttpRequest();
		xhs.onreadystatechange = processSave;
		xhs.open("post", url, true);
		xhs.send(null);
}

function processSave() {

	
	if (xhs.readyState == 4) {
		if (xhs.status == 200) {
			var str = xhs.responseText;
			alert(str);
		}
	}
}



