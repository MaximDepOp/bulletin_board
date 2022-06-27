import React, { useRef, useCallback } from "react";
import { Swiper, SwiperSlide } from "swiper/react";

import "swiper/css";
import "swiper/css/pagination";
import "swiper/css/navigation";

import { Pagination, Navigation } from "swiper";
import styles from "./Slider.module.scss";

import card1 from "@assets/card1.png";
import card2 from "@assets/card2.png";
import card3 from "@assets/card3.png";
import card4 from "@assets/card4.png";
import card5 from "@assets/card5.png";

const slides = [
  { img: `${card1}`, text: "Работа" },
  { img: `${card2}`, text: "Личные вещи" },
  { img: `${card3}`, text: "Каршеринг" },
  { img: `${card4}`, text: "Авто" },
  { img: `${card5}`, text: "Квартиры" },
];

console.log(card1);

const Slider = () => {
  const ref = useRef(null);

  const handleNext = useCallback(() => {
    if (!ref.current) return;
    ref.current.swiper.slideNext();
  }, []);

  const handlePrev = useCallback(() => {
    if (!ref.current) return;
    ref.current.swiper.slidePrev();
  }, []);

  return (
    <>
      {" "}
      <div className={styles.cards}>
        <div className={styles.card}>
          <Swiper
            slidesPerView={3}
            slidesPerGroup={1}
            grabCursor
            ref={ref}
            cssMode={true}
            className={styles.swiper}
            loop={true}
            loopFillGroupWithBlank={true}
            pagination={{
              clickable: true,
            }}
            navigation={true}
            modules={[Pagination, Navigation]}
          >
            {slides.map((slide, index) => (
              <SwiperSlide key={index} className={styles.swiperSlide}>
                <div className={styles.slide}>
                  <img className={styles.img} src={slide.img} alt="card1" />
                  <p>{slide.text}</p>
                </div>
              </SwiperSlide>
            ))}
            <span className={styles.arrowRight} onClick={handleNext} />
            <span className={styles.arrowLeft} onClick={handlePrev} />
          </Swiper>
        </div>
      </div>
    </>
  );
};

export default Slider;
