<?php
 $user_ids = themedavfly1_get_section_client_about_us();

?>
<?php
    if ( ! empty( $user_ids ) ) {
      $n = 0;
?>

<?php
      foreach ( $user_ids as $member ) {
        $member = wp_parse_args( $member, array(
                                'user_id'  =>array(),
                            ));
        $name = isset( $member['name'] ) ?  $member['name'] : '';
       
        $description = isset( $member['description'] ) ?  $member['description'] : '';
        $user_id = wp_parse_args( $member['user_id'],array(
                                'id' => '',
                             ) );
        $image_attributes = wp_get_attachment_image_src( $user_id['id'], 'devfly-mini' );
        $image_alt = get_post_meta( $user_id['id'], '_wp_attachment_image_alt', true);
           if($image_attributes[0])
          {
              $image = $image_attributes[0];
           }
          else
          {
              $image=get_template_directory_uri().'/img/t-1.jpg';
          }  
          
          
           $data = get_post( $user_id['id'] );
           $n ++ ;
        ?>
            <!--testimonial box1-->
            <div class="col-md-6 testi-box">
              <div class="col-md-6 img-box"><img src="<?php echo esc_url( $image ); ?>" class="img-responsive"></div>
              <div class="col-md-6 content-box">
                <p><?php echo esc_html( $description ); ?> <br>
                  <span><?php echo esc_html( $name ); ?></span></p>
              </div>
            </div>
            <!--/testimonial box1--> 
            
<?php
    //}
  } // end foreach
}
else
{?>
                
          <!--testimonial box1-->
            <div class="col-md-6 testi-box">
              <div class="col-md-6 img-box"><img src="<?php echo get_template_directory_uri();?>/img/t-1.jpg" class="img-responsive"></div>
              <div class="col-md-6 content-box">
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros, dictum sed leo sit amet, finibus accumsan erat. Nunc porta pellentesque est, non laoreet mi.<br>
                  <span>Steeve lehman</span></p>
              </div>
            </div>
            <!--/testimonial box1--> 
            
            <!--testimonial box2-->
            <div class="col-md-6 testi-box">
              <div class="col-md-6 img-box"><img src="<?php echo get_template_directory_uri();?>/img/t-2.jpg" class="img-responsive"></div>
              <div class="col-md-6 content-box">
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros, dictum sed leo sit amet, finibus accumsan erat. Nunc porta pellentesque est, non laoreet mi. <br>
                  <span>John Doe</span></p>
              </div>
            </div>
            <!--/testimonial box2--> 
            <!--testimonial box3-->
            <div class="col-md-6 testi-box">
              <div class="col-md-6 img-box"><img src="<?php echo get_template_directory_uri();?>/img/t-3.jpg" class="img-responsive"></div>
              <div class="col-md-6 content-box">
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros, dictum sed leo sit amet, finibus accumsan erat. Nunc porta pellentesque est, non laoreet mi. <br>
                  <span>Rijo Abraham</span></p>
              </div>
            </div>
            <!--/testimonial box3--> 
            
            <!--testimonial box4-->
            <div class="col-md-6 testi-box">
              <div class="col-md-6 img-box"><img src="<?php echo get_template_directory_uri();?>/img/t-4.jpg" class="img-responsive"></div>
              <div class="col-md-6 content-box">
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros, dictum sed leo sit amet, finibus accumsan erat. Nunc porta pellentesque est, non laoreet mi. <br>
                  <span>Ken Masters</span></p>
              </div>
            </div>
            <!--/testimonial box4--> 
                
<?php  }?>
