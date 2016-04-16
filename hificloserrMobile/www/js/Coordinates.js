/**
 * @author srikanth
 */

var Coordinates =(function(){
	
	
	return {
			lat:null,
			lng:null,
			WatchLocation:function(onSuccess,onFailure,timeOut){
							//alert("called");
							navigator.geolocation.watchPosition(onSuccess, onFailure,{timeout:timeOut});
		}
	};
})();