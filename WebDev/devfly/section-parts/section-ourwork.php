<?php
 $user_ids = themedavfly1_get_section_header_slider();
if($user_ids!='')
{    
?>

     <ol class="carousel-indicators">
 <?php
      if ( ! empty( $user_ids ) ) {
        $n = 0;
           $firstClass = 'active'; 
            foreach ( $user_ids as $member ) {
  ?>
   
      <li data-target="#carousel-example-generic" data-slide-to="<?php echo $n; ?>" class="<?php echo $firstClass; ?>"></li>
         
  <?php $n++;$firstClass = ""; } }?> 
     <!-- <li data-target="#carousel-example-generic" data-slide-to="1"></li>-->
    </ol>
    
    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">


           <?php
                    if ( ! empty( $user_ids ) ) {
                        $n = 0;
                           $firstClass = 'active'; 
                        foreach ( $user_ids as $member ) {
                            
                            $member = wp_parse_args( $member, array(
                                'user_id'  =>array(),
                            ));
                           
                            $link  = isset( $member['link'] )  ?  $member['link'] : '';
                            $name  = isset( $member['name'] )  ?  $member['name'] : 'devfly presents';
                            $title = isset( $member['title'] ) ?  $member['title'] : 'welcome to the new world';
                            $link_title = isset( $member['link_title'] ) ?  $member['link_title'] : 'TAKE A LOOK';
                            
                            $user_id = wp_parse_args( $member['user_id'],array(
                                'id' => '',
                             ) );

                            $image_attributes = wp_get_attachment_image_src( $user_id['id'], 'devfly-mini' );
                            $image_alt = get_post_meta( $user_id['id'], '_wp_attachment_image_alt', true);

                           // if ( $image_attributes ) {
                                if($image_attributes[0])
                                {
                                    
                                $image = $image_attributes[0];
                                    
                                }
                                else{
                                     $image=get_template_directory_uri().'/img/01.jpg';
                                }
                                $data = get_post( $user_id['id'] );
                                
                                $n ++ ;
                            ?>
                    
                            <div class="item <?php echo $firstClass; ?>"> <img src="<?php echo esc_url( $image ); ?>" alt="...">
                                <div class="carousel-caption animated fadeInRight" >
                                  
                                    <div class=" col-md-12 heading">
                                    <h4><?php echo esc_html( $name ); ?></h4>
                                          <?php if($name !=''){?>
                                    <hr style="width:10%;">
                                        <?php }?>
                                    <h1><?php echo esc_html( $title ); ?></h1>
                                    <?php if ( $link_title !='' ) { ?>
                                    <a href="<?php echo $link; ?>" class="btn btn-default"> <?php echo esc_html( $link_title ); ?></a> </div>
                                   
                                    
                                    <?php } //}?>
                                </div>
                            </div>

                <?php
                  $firstClass = "";  } // end foreach
                 }
                else
                {?>
                    <div class="item active"> <img src="<?php echo get_template_directory_uri();?>/img/01.jpg" alt="...">
                        <div class="carousel-caption animated fadeInRight" >
                            <div class=" col-md-12 heading">
                            <h4>devfly presents</h4>
                            <hr style="width:10%;">
                            <h1>welcome to the
                            new world</h1>
                            <a href="#" class="btn btn-default">Take a Look</a> </div>
                        </div>
                    </div>
                    <div class="item"> <img src="<?php echo get_template_directory_uri();?>/img/01.jpg" alt="...">
                        <div class="carousel-caption animated fadeInRight">
                            <div class=" col-md-12 heading">
                                <h4>devfly presents</h4>
                                <hr style="width:10%;">
                                <h1>welcome to the
                                new world</h1>
                                <a href="#" class="btn btn-default">Take a Look</a> </div>
                         </div>
                    </div>
                
                <?php  }?>
        </div>

 <!-- Controls --> 
    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev"> <span class="glyphicon glyphicon-menu-left" aria-hidden="true"></span> <span class="sr-only">Previous</span> </a> <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next"> <span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span> <span class="sr-only">Next</span> </a> 
    
    <!--scroll button--> 
    <span class="scroll-btn  wow fadeInDown " > <a href="#"><span class="mouse"><span></span></span></a>
    <p>scroll me</p>
    </span> 
    <!--scroll button--> 
<?php }?>