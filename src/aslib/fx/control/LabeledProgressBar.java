package aslib.fx.control;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.StackPane;

/**
 * <p> This component shows the progress with a percentage. It is composed by a
 * {@link ProgressBar} that shows the progress and a {@link Label} that shows
 * the percentage. </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 9.0.0
 */
public class LabeledProgressBar extends StackPane {
    private DoubleProperty progress;
    private ObjectProperty<LabelVisibilityPolicy> labelVisibilityPolicy;

    private ProgressBar bar;
    private Label label;

    /**
     * <p> Creates an {@link LabeledProgressBar} instance with the default
     * values for all the attributes. </p>
     *
     * <p> The progress value is set to -1. </p>
     *
     * <p> The visibility policy is set to {@link LabelVisibilityPolicy#AUTO}. </p>
     *
     * @since 1.0.0
     */
    public LabeledProgressBar() {
        this(-1, LabelVisibilityPolicy.AUTO);
    }

    /**
     * <p> Creates an {@link LabeledProgressBar} instance with the progress
     * value initialized. </p>
     *
     * <p> The default visibility policy is set to {@link LabelVisibilityPolicy#AUTO}. </p>
     *
     * @param progress Initial progress value. Must be between -1 and 100.
     *
     * @since 1.0.0
     */
    public LabeledProgressBar(double progress) {
        this(progress, LabelVisibilityPolicy.AUTO);
    }

    /**
     * <p> Creates an {@link LabeledProgressBar} instance with the visibility
     * policy initialized. </p>
     *
     * <p> The default progress value is set to -1. </p>
     *
     * @param policy Initial visibility policy.
     *
     * @since 1.0.0
     */
    public LabeledProgressBar(LabelVisibilityPolicy policy) {
        this(-1, policy);
    }

    /**
     * <p> Creates an {@link LabeledProgressBar} instance with all attributes
     * initialized. </p>
     *
     * @param progress Initial progress value. Must be between -1 and 100.
     * @param policy   Initial visibility policy.
     *
     * @since 1.0.0
     */
    public LabeledProgressBar(double progress, LabelVisibilityPolicy policy) {
        this.progress = new SimpleDoubleProperty(progress);
        this.labelVisibilityPolicy = new SimpleObjectProperty<>(policy);

        this.bar = new ProgressBar();
        this.label = new Label();

        configure();
    }

    /**
     * <p> Performs the general adjustments of the component. </p>
     *
     * @since 1.0.0
     */
    private void configure() {
        labelVisibilityPolicy.addListener((observable, oldValue, newValue) -> setLabelVisibilityBehavior());

        bar.progressProperty().bind(progress.divide(100));
        label.textProperty().bind(progress.asString("%.2f%%"));

        setLabelVisibilityBehavior();

        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(bar, label);
    }

    /**
     * <p> Defines how the percentage label will behave according to the policy
     * in use. </p>
     *
     * @since 1.0.0
     */
    private void setLabelVisibilityBehavior() {
        label.visibleProperty().unbind();

        switch (labelVisibilityPolicy.get()) {
            case ALWAYS:
                label.setVisible(true);
                break;
            case AUTO:
                label.visibleProperty().bind(progress.greaterThanOrEqualTo(0));
                break;
            case NEVER:
                label.setVisible(false);
                break;
        }
    }

    /**
     * <p> Gets the current progress of this component. </p>
     *
     * @return The progress of this component. The value is between -1 and 100.
     *
     * @since 1.0.0
     */
    public double getProgress() {
        return progress.get();
    }

    /**
     * <p> Sets the progress value to this component. </p>
     *
     * @param progress Progress that will be defined. The range must be between -1 and 100.
     *
     * @since 1.0.0
     */
    public void setProgress(double progress) {
        this.progress.set(progress);
    }

    /**
     * <p> Gets the progress property of this component. </p>
     *
     * @return Progress property of this component.
     *
     * @since 1.0.0
     */
    public DoubleProperty progressProperty() {
        return progress;
    }

    /**
     * <p> Gets the current style of the progress bar. </p>
     *
     * @return The style currently in use.
     *
     * @since 1.0.0
     */
    public String getProgressBarStyle() {
        return bar.getStyle();
    }

    /**
     * <p> Sets the style to the progress bar. </p>
     *
     * @param style Style that will be defined.
     *
     * @since 1.0.0
     */
    public void setProgressBarStyle(String style) {
        bar.setStyle(style);
    }

    /**
     * <p> Gets the style property of the progress bar. </p>
     *
     * @return Style property of the progress bar.
     *
     * @since 1.0.0
     */
    public StringProperty progressBarStyleProperty() {
        return bar.styleProperty();
    }

    /**
     * <p> Gets the current style of the percentage label. </p>
     *
     * @return The style currently in use.
     *
     * @since 1.0.0
     */
    public String getLabelStyle() {
        return label.getStyle();
    }

    /**
     * <p> Sets the style to the percentage label. </p>
     *
     * @param style Style that will be defined.
     *
     * @since 1.0.0
     */
    public void setLabelStyle(String style) {
        label.setStyle(style);
    }

    /**
     * <p> Gets the style property of the percentage label. </p>
     *
     * @return Style property of the percentage label.
     *
     * @since 1.0.0
     */
    public StringProperty labelStyleProperty() {
        return label.styleProperty();
    }

    /**
     * <p> Gets the visibility status of the percentage label. </p>
     *
     * @return Whether the percentage label is visible or not.
     *
     * @since 1.0.0
     */
    public boolean isLabelVisible() {
        return label.isVisible();
    }

    /**
     * <p> Gets the current visibility policy. </p>
     *
     * @return The policy currently in use.
     *
     * @since 1.0.0
     */
    public LabelVisibilityPolicy getLabelVisibilityPolicy() {
        return labelVisibilityPolicy.get();
    }

    /**
     * <p> Sets the visibility policy of the percentage label. </p>
     *
     * @param policy Policy that will be defined.
     *
     * @since 1.0.0
     */
    public void setLabelVisibilityPolicy(LabelVisibilityPolicy policy) {
        this.labelVisibilityPolicy.set(policy);
    }

    /**
     * <p> Defines the visibility behavior of the percentage label. </p>
     *
     * @author Adriano Siqueira
     * @version 1.0.0
     * @since 9.0.0
     */
    public enum LabelVisibilityPolicy {
        /**
         * <p> Always show the percentage label. </p>
         *
         * @since 1.0.0
         */
        ALWAYS,

        /**
         * <p> Show percentage label when the percentage is greater than or
         * equal to zero. </p>
         *
         * @since 1.0.0
         */
        AUTO,

        /**
         * <p> Never show the percentage label. </p>
         *
         * @since 1.0.0
         */
        NEVER
    }
}