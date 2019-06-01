<?php 

    if(isset($_GET['link'])){
		
?>

<div class="mapa">
    
    <iframe src="<?php echo($_GET['link']); ?>" 
		style="border:0; width:700px; height:250px;" class="iframe" allowfullscreen>
        
    </iframe>
</div>

<?php
	 } 
?>