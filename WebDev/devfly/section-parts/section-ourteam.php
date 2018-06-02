<?php
 $user_ids = themedavfly1_get_section_our_team();

?>
<?php
    if ( ! empty( $user_ids ) ) {
      $n = 0;
      foreach ( $user_ids as $member ) {
        $member = wp_parse_args( $member, array(
                                'user_id'  =>array(),
                            ));
       // $link = isset( $member['link'] ) ?  $member['link'] : '';
        $name = isset( $member['name'] ) ?  $member['name'] : '';
        $designation = isset( $member['designation'] ) ?  $member['designation'] : '';
        $description = isset( $member['description'] ) ?  $member['description'] : '';
          
        $facebook_title = isset( $member['facebook_title'] ) ?  $member['facebook_title'] : 'facebook';
        $facebook_link = isset( $member['facebook_link'] ) ?  $member['facebook_link'] : 'https://www.facebook.com/';
        $twitter_title = isset( $member['twitter_title'] ) ?  $member['twitter_title'] : 'twitter';
        $twitter_link = isset( $member['twitter_link'] ) ?  $member['twitter_link'] : 'https://twitter.com/login';   
        $instagram_title = isset( $member['instagram_title'] ) ?  $member['instagram_title'] : 'instagram';
        $instagram_link = isset( $member['instagram_link'] ) ?  $member['instagram_link'] : 'https://www.instagram.com';        
        $user_id = wp_parse_args( $member['user_id'],array(
                                'id' => '',
                             ) );
        $image_attributes = wp_get_attachment_image_src( $user_id['id'], 'devfly-mini' );
        $image_alt = get_post_meta( $user_id['id'], '_wp_attachment_image_alt', true);
       // if ( $image_attributes ) {
          // $image = $image_attributes[0];
          if($image_attributes[0])
          {
              $image = $image_attributes[0];
           }
          else
          {
              $image=get_template_directory_uri().'/img/team/01.jpg';
          }  
          
           $data = get_post( $user_id['id'] );
           $n ++ ;
        ?>


        <div class="item">
          <div class="thumbnail"> <img src="<?php echo esc_url( $image ); ?>" alt="..." class="img-circle team-img">
            <div class="caption">
              <h3><?php echo esc_html( $name ); ?></h3>
              <p><?php echo esc_html( $designation ); ?></p>
              <p><?php echo esc_html( $description ); ?></p>
              <ul>
                <li><a href="<?php echo esc_html( $facebook_link ); ?>"><i class="fa fa-<?php echo esc_html( $facebook_title ); ?>"></i></a></li>
                <li><a href="<?php echo esc_html( $twitter_link ); ?>"><i class="fa fa-<?php echo esc_html( $twitter_title ); ?>"></i></a></li>
                <li><a href="<?php echo esc_html( $instagram_link ); ?>"><i class="fa fa-<?php echo esc_html( $instagram_title ); ?>"></i></a></li>               
              </ul>
            </div>
          </div>
        </div>

<?php
    //}
  } // end foreach
}
else
{?>
                
        <div class="item">
          <div class="thumbnail"> <img src="<?php echo get_template_directory_uri();?>/img/team/01.jpg" alt="..." class="img-circle team-img">
            <div class="caption">
              <h3>Aaron Solomon</h3>
              <p>CEO / Founder</p>
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros, dictum sed leo sit amet.</p>
              <ul>
                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
              </ul>
            </div>
          </div>
        </div>
        <div class="item">
          <div class="thumbnail"> <img src="<?php echo get_template_directory_uri();?>/img/team/02.jpg" alt="..." class="img-circle team-img">
            <div class="caption">
              <h3>David Yakob</h3>
              <p>CEO / Founder</p>
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros, dictum sed leo sit amet.</p>
              <ul>
                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
              </ul>
            </div>
          </div>
        </div>
        <div class="item">
          <div class="thumbnail"> <img src="<?php echo get_template_directory_uri();?>/img/team/03.jpg" alt="..." class="img-circle team-img">
            <div class="caption">
              <h3>Mosess Jr</h3>
              <p>CEO / Founder</p>
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros, dictum sed leo sit amet.</p>
              <ul>
                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
              </ul>
            </div>
          </div>
        </div>
        <div class="item">
          <div class="thumbnail"> <img src="<?php echo get_template_directory_uri();?>/img/team/04.jpg" alt="..." class="img-circle team-img">
            <div class="caption">
              <h3>Gwapa Jenn </h3>
              <p>CEO / Founder</p>
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros, dictum sed leo sit amet.</p>
              <ul>
                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
              </ul>
            </div>
          </div>
        </div>
        <div class="item">
          <div class="thumbnail"> <img src="<?php echo get_template_directory_uri();?>/img/team/04.jpg" alt="..." class="img-circle team-img">
            <div class="caption">
              <h3>Mosess Gwapa</h3>
              <p>CEO / Founder</p>
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros, dictum sed leo sit amet.</p>
              <ul>
                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
              </ul>
            </div>
          </div>
        </div>
        <div class="item">
          <div class="thumbnail"> <img src="<?php echo get_template_directory_uri();?>/img/team/01.jpg" alt="..." class="img-circle team-img">
            <div class="caption">
              <h3>Jenn Gwapa</h3>
              <p>CEO / Founder</p>
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros, dictum sed leo sit amet.</p>
              <ul>
                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
              </ul>
            </div>
          </div>
        </div>
        <div class="item">
          <div class="thumbnail"> <img src="<?php echo get_template_directory_uri();?>/img/team/02.jpg" alt="..." class="img-circle team-img">
            <div class="caption">
              <h3>Jenn Gwapa</h3>
              <p>CEO / Founder</p>
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros, dictum sed leo sit amet.</p>
              <ul>
                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
              </ul>
            </div>
          </div>
        </div>
        <div class="item">
          <div class="thumbnail"> <img src="<?php echo get_template_directory_uri();?>/img/team/03.jpg" alt="..." class="img-circle team-img">
            <div class="caption">
              <h3>Jenn Gwapa</h3>
              <p>CEO / Founder</p>
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros, dictum sed leo sit amet.</p>
              <ul>
                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
              </ul>
            </div>
          </div>
        </div>
                
<?php  }?>
