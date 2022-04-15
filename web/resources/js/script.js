// Default tab
      $(".tab").css("display", "none");
      $("#tab-1").css("display", "block");

      function run(hideTab, showTab){
          document.getElementById("addgrantor").style.display = "block";
        if(hideTab<showTab){ // If not press previous button
          // Validation if press next button
          var currentTab = 0;
          x = $('#tab-'+hideTab);
          y = $(x).find("input")
          
          /*
           * for (i = 0; i < y.length; i++){
            if (y[i].value == ""){
              $(y[i]).css("background", "#ffdddd");
              return false;
            }
          }
           */
        }

        // Progress bar
        for (i = 1; i < showTab; i++){
          $("#step-"+i).css("opacity", "1");
          $("#steptitle-"+i).css("opacity", "1"); 
        }

        // Switch tab
        $("#tab-"+hideTab).css("display", "none");
        $("#tab-"+showTab).css("display", "block");
        $("input").css("background", "#fff");
      }
      
      function showVehicle(checked){ 
          if(checked === true){ 
               $("#propertyVehicle").fadeIn(); 
          }
          else { 
               $("#propertyVehicle").fadeOut(); 
          }
      }
      
      function showHouse(checked){ 
          if(checked === true){ 
               $("#propertyHouse").fadeIn(); 
               document.getElementById("propertyHouse").style.marginTop="-3%";
          }
          else { 
               $("#propertyHouse").fadeOut(); 
          }
      }
      
      function showOrg(checked){ 
          if(checked == true){ 
               $("#propertyOrg").fadeIn(); 
               document.getElementById("propertyOrg").style.marginTop="-3%";
          }
          else { 
               $("#propertyOrg").fadeOut(); 
          }
      } 
      
      $(document).ready(function () {
          $("#customertype").on('change',function () {
              $("#"+$(this).val()).fadeIn();
              if($(this).val() === "Individual"){
                  $("#custInd").fadeIn();                 
                  $("#custaddress").fadeIn();
                  $("#custOrg").fadeOut(); 
              }
              else  if($(this).val() === "Organization"){
                  $("#custOrg").fadeIn(); 
                  $("#custInd").fadeOut();                 
                  $("#custaddress").fadeIn();
              }
          });
      });
      
 function testCancel() {

if(document.getElementById('data_changed')!== null && document.getElementById('data_changed').value === "Y") {
	submitJS();
	return false;
} else {
	return true;
}
}

