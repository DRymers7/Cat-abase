/** @type {import('tailwindcss').Config} */
module.exports = {
content: ["./src/**/*.{html,js,jsx,ts,tsx,vue}"],
  mode: "jit",
  theme: {
    extend: {
      colors: {
        // basic color classes pre set
        "deep-blue": "#010026",
        blue: "#2430ab",
        red: "#5727b3",
        yellow: "#b1b1b1",
        grey: "#625c5c",
        "dark-grey": "#757575",
        "opaque-black": "rgba(0,0,0,0.35)",
      },
      backgroundImage: (theme) => ({
        "gradient-rainbow":"linear-gradient(81.66deg, #00B5EE 7.21%, #FF45A4 45.05%, #FFBA00 78.07%)",

        "gradient-rainblue":"linear-gradient(90deg, #24CBFF 14.53%, #FC59FF 69.36%, #FFBD0C 117.73%)",
      }),
      fontFamily: {
        playfair: ["Playfair Display", "serif"],
        opensans: ["Open Sans", "sans-serif"],
      },
      content: {
        // allows use of content in the before and after pseudo elements (pictures, etc.)
      },
    },
    screens: {
      // allows us to make website responsive and gives classnames for screen sizes
      sm: "640px",
      md: "768px",
      lg: "1024px",
      xl: "1280px",
      "2xl": "1536px",

    },
  },
  plugins: [],
};