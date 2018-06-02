<?php
 $user_ids = themedavfly1_get_section_footer_payemnt();

?>
<?php
    if ( ! empty( $user_ids ) ) {
      $n = 0;
      foreach ( $user_ids as $member ) {
        $member = wp_parse_args( $member, array(
                                'user_id'  =>array(),
                            ));
      
        $user_id = wp_parse_args( $member['user_id'],array(
                                'id' => '',
                             ) );
        $image_attributes = wp_get_attachment_image_src( $user_id['id'], 'devfly-mini' );
        $image_alt = get_post_meta( $user_id['id'], '_wp_attachment_image_alt', true);
        if ( $image_attributes ) {
           $image = $image_attributes[0];
           $data = get_post( $user_id['id'] );
           $n ++ ;
        ?>

        <li><img src="<?php echo esc_url( $image ); ?>" class="img-responsive"></li>

<?php
    }
  } // end foreach
}
else
{?>            
            <li><img src="<?php echo get_template_directory_uri();?>/img/visa.jpg" class="img-responsive"></li>
            <li><img src="<?php echo get_template_directory_uri();?>/img/matro.jpg" class="img-responsive"></li>
            <li><img src="<?php echo get_template_directory_uri();?>/img/thatwe.jpg" class="img-responsive"></li>
            <li><img src="<?php echo get_template_directory_uri();?>/img/american.jpg" class="img-responsive"></li>
            <li><img src="<?php echo get_template_directory_uri();?>/img/matro.jpg" class="img-responsive"></li>
            <li><img src="<?php echo get_template_directory_uri();?>/img/payment.jpg" class="img-responsive"></li>
                
<?php  }?>
