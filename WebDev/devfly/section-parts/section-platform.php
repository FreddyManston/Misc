<?php
 $user_ids = themedavfly1_get_section_about_platform();

?>
<?php
    if ( ! empty( $user_ids ) ) {
      $n = 0;
      foreach ( $user_ids as $member ) {
        $member = wp_parse_args( $member, array(
                                'user_id'  =>array(),
                            ));
        $link = isset( $member['link'] ) ?  $member['link'] : '';
        $title = isset( $member['title'] ) ?  $member['title'] : '';
        $description = isset( $member['description'] ) ?  $member['description'] : '';
        $linktitle = isset( $member['linktitle'] ) ?  $member['linktitle'] : ''; 
          
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
          else
          {
              $image=get_template_directory_uri().'/img/feature-icon.png';
          }
          
          
           $data = get_post( $user_id['id'] );
           $n ++ ;
        ?>
                    <div class="col-md-4 box text-center"><img src="<?php echo esc_url( $image ); ?>" class=" d-block m-x-auto option-icon">
                    <h4><?php echo esc_html( $title ); ?></h4>
                    <p><?php echo esc_html( $description ); ?></p>
                      <?php if($linktitle){?>    
                    <a href="<?php echo esc_html( $link ); ?>" ><?php echo esc_html( $linktitle ); ?></a>
                    <?php }?>   
                    </div>

<?php
    //}
  } // end foreach
}
else
{?>
                
<!--box1-->
      <div class="col-md-4 box text-center"> <img src="<?php echo get_template_directory_uri();?>/img/feature-icon.png" class=" d-block m-x-auto option-icon">
        <h4> Technology</h4>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros, dictum sed leo sit amet, finibus accumsan erat. Nunc porta pellentesque est, non laoreet mi. </p>
        <a href="#" >Learn more</a> 
      </div>
      <!--/box1--> 
      
      <!--box2-->
      <div class="col-md-4 box  text-center"> <img src="<?php echo get_template_directory_uri();?>/img/feature-icon.png" class="phone-icon d-block m-x-auto">
        <h4> Mobile </h4>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros, dictum sed leo sit amet, finibus accumsan erat. Nunc porta pellentesque est, non laoreet mi. </p>
        <a href="#" >Learn more</a> </div>
      <!--/box2--> 
      
      <!--box3-->
      <div class="col-md-4 box text-center"> <img src="<?php echo get_template_directory_uri();?>/img/feature-icon.png" class="desktop-icon d-block m-x-auto">
        <h4> Desktop</h4>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros, dictum sed leo sit amet, finibus accumsan erat. Nunc porta pellentesque est, non laoreet mi. </p>
        <a href="#" >Learn more</a> </div>
      <!--/box3--> 
                
<?php  }?>