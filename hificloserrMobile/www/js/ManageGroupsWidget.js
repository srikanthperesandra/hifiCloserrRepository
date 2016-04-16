/**
 * @author srikanth
 */
$.ajaxSetup({async:false});
$.getScript("jqwidgets/jqxcore.js");
$.getScript("jqwidgets/jqxdata.js");
$.getScript("jqwidgets/jqxbuttons.js");
$.getScript("jqwidgets/jqxscrollbar.js");
$.getScript("jqwidgets/jqxlistbox.js");
$.ajaxSetup({async:true});
var ManageGroupsWidget = (function(){
	
	
	return{
			groupsList:null,
			groups_uri:"services/chatrooms",
			init:function(id){
				var thisRef = this;	
				this.groupsList = $("#"+id);
				$.ajax({ url: 'templates/ManageGroupsWidget.html', dataType: 'html',
					
					success: function(response) { 
								thisRef.groupsList.html(response);
								try{
									
								}catch(error){
									alert(error);
								}
								
							}
				});
			},
			update:function(lat,lng){
				alert(lat);
				$.get( appConfig.hifiServiceEndPoint+this.groups_uri+"?lat="+lat+"&lng="+lng+"&area="+appConfig.areaCoverage).done(function( data ) {
					//alert(data);
						
						alert(JSON.stringify(data));
						
					}).fail(function(error){
						alert(error);
					});
			}
			
	};
})();