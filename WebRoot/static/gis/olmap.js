﻿/**
 * Created by tanshuai on 15/5/21.
 */
$(document).ready(function() {


    //ArcGIS Server
	var arcgisUrl = 'http://218.94.6.92:6080/arcgis/rest/services/jssl_vector_L3_L17/MapServer';
    var ext = ol.extent.applyTransform([46.106590272699194, -41.71601898399485, 186.3758766536811, 77.29287821608672],
        ol.proj.getTransform("EPSG:4326", "EPSG:3857"));
    var restLayer = new ol.layer.Tile({
        extent: ext,
        source: new ol.source.TileArcGISRest({
            url: arcgisUrl
        })
    });

    //popup
    
    var container = document.getElementById('popup');
    var content = document.getElementById('popup-content');
    var closer = document.getElementById('popup-closer');
    var overlay = new ol.Overlay(/** @type {olx.OverlayOptions} */ ({
        element: container,
        autoPan: true,
        autoPanAnimation: {
          duration: 250
        }
      }));
    closer.onclick = function() {
        overlay.setPosition(undefined);
        closer.blur();
        return false;
      };
      
      
      
      
    
    //point
      var style = new ol.style.Style({  
    	  image:new ol.style.Icon({  
    	       color:'#000000',  
    	       src: base_path+'/static/image/dot.png'  
         })});
      var points = [];
      
      list = [{id:'南京',coor:[118.46,32.03]},{id:'淮安',coor:[119.15	,33.5]},{id:'时埝',coor:[119.5, 31.5]}];
      
//      $.ajax({
//    	 url:'/SharingPlatform/data/gisST',
//    	 async:false,
//    	 success:function(data){
//    		 console.log("success");
//    		 list = data;
//    	 }
//      });
      
      console.log(list);
      for(var i=0;i<list.length;i++){
//		  coor = [parseFloat(list[i].LGTD)+0.2,parseFloat(list[i].LTTD)];
    	  coor = list[i].coor;
		  console.log(coor)
    	  var tmp = new ol.Feature({  
    	        geometry:new ol.geom.Point(ol.proj.fromLonLat(coor)),
    	        id: list[i].id
    	    });
    	  tmp.setStyle(style);
    	  points.push(tmp);
//    	  if(i > 10)
//    		  break;
      }
    
    var source = new ol.source.Vector({  
        features:points 
    });  
    var points = new ol.layer.Vector({  
        source: source,
        minResolution: 0,
        maxResolution: 600
    });
    
    var layers = [
        restLayer,points
    ];


    var map = new ol.Map({
        layers: layers,
        target: 'mapMain',
        overlays: [overlay],
        view: new ol.View({
            center: ol.proj.transform([118.46,32.03], 'EPSG:4326', 'EPSG:3857'),
            zoom: 10,
            //center: [119.5, 31.5],
            //projection:'EPSG:4326',
            //zoom: 14,
            maxZoom: 20
        })
    });
//  //定义select控制器
    var select= new ol.interaction.Select({
    	condition: ol.events.condition.click,  
    	style: new ol.style.Style({  
            image:new ol.style.Icon({  
            	src : base_path+'/static/image/dot.png',
            	scale : 1
             })}),
    });
    map.addInteraction(select);//map加载该控件，默认是激活可用的
    
    

    
    select.on('select', function(e) {
    	console.log("hahahah");
    	var feature = e.target.getFeatures().getArray()[0];
    	if(feature != null){
    		var id = feature.get('id');
        	var coordinate = feature.getGeometry().getCoordinates();
        	$.get(base_path+"/gis/sw/63202911",function(data){
				str = '水位:'+data;
				content.innerHTML = str;
				overlay.setPosition(coordinate);
        	});
    	}
    });


});
