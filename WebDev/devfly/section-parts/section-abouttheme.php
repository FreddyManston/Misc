<?php
 $user_ids = themedavfly1_get_section_about_theme();
 $user_idss = themedavfly1_get_section_about_theme();
?>
 <!-- Nav tabs -->           
            <?php
                 if ( ! empty( $user_ids ) ) {                    
                     ?>
                <ul class="nav nav-tabs" role="tablist">
              <?php             
                     $n = 0;
                        $firstClass = 'active'; 
                        foreach ( $user_ids as $members ) {
                            
                            $members = wp_parse_args( $members, array(
                                'user_id'  =>array(),
                            ));
                           
                            $mainheads = isset( $members['mainhead'] ) ?  $members['mainhead'] : 'About';
                if($mainheads !='')  
                {
            ?>
            
          <li role="presentation" class="<?php echo $firstClass; ?> about-section"><a href="#<?php echo esc_html( $mainheads ); ?>" aria-controls="home" role="tab" data-toggle="tab"><?php echo esc_html( $mainheads ); ?></a></li>
            
          <?php } $n++;$firstClass = ""; }?>
           </ul>
          <?php       
           }else{?>
             <ul  class="nav nav-tabs" role="tablist">
          <li role="presentation"><a href="#about" aria-controls="about" role="tab" data-toggle="tab">ABOUT</a></li>  
          <li role="presentation"><a href="#design" aria-controls="profile" role="tab" data-toggle="tab">DESIGN</a></li>
          <li role="presentation"><a href="#feature" aria-controls="messages" role="tab" data-toggle="tab">FEATURES</a></li>
            </ul> 

        <?php }?>
        <!-- Tab panes -->
        <div class="tab-content"> 
          <!-- about panes -->
            
            
             <?php
                    if ( ! empty( $user_idss ) ) {
                        $n = 0;
                           $firstClass = 'active'; 
                        foreach ( $user_idss as $member ) {
                            
                            $member = wp_parse_args( $member, array(
                                'user_id'  =>array(),
                            ));
                           
                            $mainhead = isset( $member['mainhead'] ) ?  $member['mainhead'] : '';
                            $title = isset( $member['title'] ) ?  $member['title'] : 'devfly presents';
                            $description = isset( $member['description'] ) ?  $member['description'] : 'welcome to the new world';
                            
                            
                            $user_id = wp_parse_args( $member['user_id'],array(
                                'id' => '',
                             ) );

                            $image_attributes = wp_get_attachment_image_src( $user_id['id'], 'devfly-mini' );
                            $image_alt = get_post_meta( $user_id['id'], '_wp_attachment_image_alt', true);

                            //if ( $image_attributes ) {
                                                         
                            if($image_attributes[0])
                                {
                                    
                                $image = $image_attributes[0];
                                    
                                }
                                else{
                                     $image=get_template_directory_uri().'/img/d-1.jpg';
                                }
                            
                                $data = get_post( $user_id['id'] );
                                $n ++ ;
             ?>
        
          <div role="tabpanel" class="tab-pane <?php echo $firstClass; ?>" id="<?php echo esc_html( $mainhead ); ?>">
            <div class="col-md-6 side-image"> <img src="<?php echo esc_url( $image ); ?>" class="img-responsive" alt=""> </div>
            <div class="col-md-6 content-box"> 
              
                    <h3><?php echo esc_html( $title ); ?></h3>
                    <p><?php echo esc_html( $description ); ?> </p>
                
              
            </div>
          </div>
            
            <?php
              //}
              $firstClass = "";  
              }
            }
            else{
              ?>
            
            
          <!--/about panes --> 
          <div role="tabpanel" class="tab-pane active" id="about">
            <div class="col-md-6 side-image"> <img src="<?php echo get_template_directory_uri();?>/img/d-1.jpg" class="img-responsive" alt=""> </div>
            <div class="col-md-6 content-box"> 

                    <h3>Where does it come from</h3>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros, dictum sed leo sit amet, finibus accumsan erat. Nunc porta pellentesque est, non laoreet mi. Mauris eu tortor ut nulla bibendum gravida. Pellentesque id felis nec ante euismod gravida. Orci varius natoque penatibus et magnis dis parturient montes, </p>
  
            </div>
          </div>
          <!-- design panes -->
          <div role="tabpanel" class="tab-pane" id="design">
            <div class="col-md-6 side-image"> <img src="<?php echo get_template_directory_uri();?>/img/d-2.jpg" class="img-responsive" alt=""> </div>
            <div class="col-md-6 content-box"> 
            <h3>Where does it come from</h3>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros, dictum sed leo sit amet, finibus accumsan erat. Nunc porta pellentesque est, non laoreet mi. Mauris eu tortor ut nulla bibendum gravida. Pellentesque id felis nec ante euismod gravida. Orci varius natoque penatibus et magnis dis parturient montes, </p>
              
            </div>
          </div>
          <!--/design panes --> 
          
          <!-- features panes -->
          <div role="tabpanel" class="tab-pane" id="feature">
            <div class="col-md-6 side-image"> <img src="<?php echo get_template_directory_uri();?>/img/d-3.jpg" class="img-responsive" alt=""> </div>
            <div class="col-md-6 content-box"> 
              
             <h3>Where does it come from</h3>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros, dictum sed leo sit amet, finibus accumsan erat. Nunc porta pellentesque est, non laoreet mi. Mauris eu tortor ut nulla bibendum gravida. Pellentesque id felis nec ante euismod gravida. Orci varius natoque penatibus et magnis dis parturient montes, </p>
              
            </div>
          </div>
          <!--/features panes --> 
          <?php } ?>
        </div>