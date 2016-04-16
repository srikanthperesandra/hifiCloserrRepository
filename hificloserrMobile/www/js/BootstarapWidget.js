/**
 *@author srikanth 
 */
$.ajaxSetup({async:false});
$.getScript("jqwidgets/jqxcore.js");
$.getScript("jqwidgets/jqxdata.js");
$.getScript("jqwidgets/jqxtabs.js");
$.getScript("js/appConfig.js");
$.getScript("js/Coordinates.js");
$.getScript("js/ManageGroupsWidget.js");
$.ajaxSetup({async:true});
 var BootstrapWidget=(function(){
	
	return {
		
		tabConatiner:null,
		templateStr:null,
		prevLat:null,
		prevLng:null,
		init:function(id){
			var thisRef = this;
			this.tabContainer = $("#"+id);
			$.ajax({ url: 'templates/BootstrapWidget.html', dataType: 'html', 
				success: function(response) { 
							thisRef.tabContainer.html(response);
							
						
							try{
								thisRef.prepareTabcontainer();
								Coordinates.WatchLocation(thisRef.getChangedCoordinates,thisRef.onFetchFailure,appConfig.locationWatchoutTimePeriod);
								ManageGroupsWidget.init("groups");
							}catch(error){
								alert(error);
							}
							
						}
			});
			
		},
		prepareTabcontainer:function(){
			//alert($("#tabs"));
			$("#tabs").jqxTabs({ animationType: 'fade',theme:appConfig.theme});
		},
		getChangedCoordinates:function(location){
			var lat = location.coords.latitude;
			var lng = location.coords.longitude;
			//alert(Coordinates.lat);
			/*if(Coordinates.lat==null||Coordinates.lng==null){
				Coordinates.lat=lat;
				Coordinates.lng=lng;
				ManageGroupsWidget.update(lat,lng);
				return;
			}
			if(Coordinates.lat==lat&&Coordinates.lng==lng){
				return;
			}*/
			try{
				ManageGroupsWidget.update(lat,lng);
			}catch(e){
				alert(e);
			}
			
			
		},
		onFetchFailure:function(error){
			alert('code: '    + error.code    + '\n' +
		              'message: ' + error.message + '\n');
		}
		
	};

})();