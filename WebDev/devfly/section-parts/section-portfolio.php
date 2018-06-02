<?php
 $user_ids = themedavfly1_get_section_portfolio();

?>
<?php
    if ( ! empty( $user_ids ) ) {
      $n = 0;
      foreach ( $user_ids as $member ) {
        $member = wp_parse_args( $member, array(
                                'user_id'  =>array(),
                            ));
        
        $name = isset( $member['title'] ) ?  $member['title'] : '';
       
        $description = isset( $member['description'] ) ?  $member['description'] : '';
       /* $readmore=isset( $member['readmore'] ) ?  $member['readmore'] : 'Read More';
        $link = isset( $member['link'] ) ?  $member['link'] : '';*/
          
        $user_id = wp_parse_args( $member['user_id'],array(
                                'id' => '',
                             ) );
        $image_attributes = wp_get_attachment_image_src( $user_id['id'], 'devfly-mini' );
        $image_alt = get_post_meta( $user_id['id'], '_wp_attachment_image_alt', true);
       // if ( $image_attributes ) {
         //  $image = $image_attributes[0];
           
          if($image_attributes[0])
          {
              $image = $image_attributes[0];
           }
          else
          {
              $image=get_template_directory_uri().'/img/d-2.jpg';
          }
           $data = get_post( $user_id['id'] );
           $n ++ ;
        ?>
        <div class="item"> 
          <!--portfolio list-->
          <div class="portfolio-list">
              <div class="col-md-6 portfolio-img"><a  href="<?php echo esc_url( $image ); ?>" class="single_image " title="<?php echo esc_html( $name ); ?>">  <img src="<?php echo esc_url( $image ); ?>" class="img-responsive"></a></div>
            <div class="col-md-6 portfolio-content">
              <h3><?php echo esc_html( $name ); ?></h3>
              <p><?php echo esc_html( $description ); ?></p>
            </div>
          </div>
          <!--/portfolio list--> 
        </div>
<?php
  //  }
  } // end foreach
}
else
{?>             
        <div class="item"> 
          <!--portfolio list-->
          <div class="portfolio-list">
            <div class="col-md-6 portfolio-img"><a href="<?php echo get_template_directory_uri();?>/img/d-2.jpg" class="single_image " title="Project Gold"><img src="<?php echo get_template_directory_uri();?>/img/d-2.jpg" class="img-responsive"></a></div>
            <div class="col-md-6 portfolio-content">
              <h3>Project Gold</h3>
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros, dictum sed leo sit amet, finibus accumsan erat. Nunc porta pellentesque est, non laoreet mi. Mauris eu tortor ut nulla bibendum gravida. Pellentesque id felis nec ante euismod gravida. </p>
            </div>
          </div>
          <!--/portfolio list--> 
        </div>
        <div class="item"> 
          <!--portfolio list-->
          <div class="portfolio-list">
            <div class="col-md-6 portfolio-img"><a href="<?php echo get_template_directory_uri();?>/img/d-3.jpg" class="single_image " title="Project Red"><img src="<?php echo get_template_directory_uri();?>/img/d-3.jpg" class="img-responsive"></a></div>
            <div class="col-md-6 portfolio-content">
              <h3>Project Red</h3>
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros, dictum sed leo sit amet, finibus accumsan erat. Nunc porta pellentesque est, non laoreet mi. Mauris eu tortor ut nulla bibendum gravida. Pellentesque id felis nec ante euismod gravida. </p>
            </div>
          </div>
          <!--/portfolio list--> 
                
<?php  }?>
