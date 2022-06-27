const { alias } = require("react-app-rewire-alias");

module.exports = function override(config, env) {
  alias({
    "@assets": "src/assets",
    "@components": "src/components",
    "@hooks": "src/hooks",
    "@layout": "src/layout",
    "@pages": "src/pages",
    "@routing": "src/routing",
    "@ui": "src/ui",
  })(config);
  return config;
};
